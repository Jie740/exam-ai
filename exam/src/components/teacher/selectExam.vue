//查询所有考试
<template>
  <div class="exam">
    <!-- 筛选区域 -->
    <div class="filter-container">
      <div class="filter-item">
        <span class="filter-label" >试卷名称：</span>
        <el-input v-model="examName" placeholder="请输入试卷名称" clearable></el-input>
         <div class="filter-action">
        <el-button type="primary" @click="searchExam()">查询</el-button>
      </div>
    </div>
    </div>
    
    <el-table :data="filteredData" border>
      <el-table-column fixed="left" prop="source" label="试卷名称" width="180"></el-table-column>
      <el-table-column prop="description" label="介绍" width="200"></el-table-column>
      <el-table-column prop="institute" label="所属学院" width="120"></el-table-column>
      <el-table-column prop="major" label="所属专业" width="200"></el-table-column>
      <el-table-column prop="grade" label="年级" width="100"></el-table-column>
      <el-table-column prop="examDate" label="考试日期" width="120"></el-table-column>
      <el-table-column prop="totalTime" label="持续时间" width="120"></el-table-column>
      <el-table-column prop="totalScore" label="总分" width="120"></el-table-column>
      <el-table-column prop="type" label="试卷类型" width="120"></el-table-column>
      <el-table-column prop="tips" label="考生提示" width="400"></el-table-column>
      <el-table-column fixed="right" label="操作" width="150">
        <template slot-scope="scope">
          <el-button @click="edit(scope.row.examCode)" type="primary" size="small">编辑</el-button>
          <el-button @click="deleteRecord(scope.row.examCode)" type="danger" size="small">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    <el-pagination
      @size-change="handleSizeChange"
      @current-change="handleCurrentChange"
      :current-page="pagination.current"
      :page-sizes="[4, 8, 10, 20]"
      :page-size="pagination.size"
      layout="total, sizes, prev, pager, next, jumper"
      :total="pagination.total" class="page">
    </el-pagination>
    <!-- 编辑对话框-->
    <el-dialog
      title="编辑试卷信息"
      :visible.sync="dialogVisible"
      width="30%"
      :before-close="handleClose">
      <section class="update">
        <el-form ref="form" :model="form" label-width="80px">
          <el-form-item label="试卷名称">
            <el-input v-model="form.source"></el-input>
          </el-form-item>
          <el-form-item label="介绍">
            <el-input v-model="form.description"></el-input>
          </el-form-item>
          <el-form-item label="所属学院">
            <el-input v-model="form.institute"></el-input>
          </el-form-item>
          <el-form-item label="所属专业">
            <el-input v-model="form.major"></el-input>
          </el-form-item>
          <el-form-item label="年级">
            <el-input v-model="form.grade"></el-input>
          </el-form-item>
          <el-form-item label="考试日期">
            <el-col :span="11">
              <el-date-picker type="date" placeholder="选择日期" v-model="form.examDate" style="width: 100%;"></el-date-picker>
            </el-col>
          </el-form-item>
          <el-form-item label="持续时间">
            <el-input v-model="form.totalTime"></el-input>
          </el-form-item>
          <el-form-item label="总分">
            <el-input v-model="form.totalScore"></el-input>
          </el-form-item>
          <el-form-item label="试卷类型">
            <el-input v-model="form.type"></el-input>
          </el-form-item>
          <el-form-item label="考生提示">
            <el-input type="textarea" v-model="form.tips"></el-input>
          </el-form-item>
        </el-form>
      </section>
      <span slot="footer" class="dialog-footer">
        <el-button @click="dialogVisible = false">取 消</el-button>
        <el-button type="primary" @click="submit()">确 定</el-button>
      </span>
    </el-dialog>
  </div>
</template>

<script>
export default {
  data() {
    return {
      examName: '', // 试卷名称
      form: {}, //保存点击以后当前试卷的信息
      pagination: { //分页后的考试信息
        current: 1, //当前页
        total: null, //记录条数
        size: 4 //每页条数
      },
      dialogVisible: false,
      // 筛选表单
      filterForm: {
        type: '', // 试卷类型
        institute: '', // 所属学院
        grade: '' // 年级
      },
      // 原始数据列表
      originalRecords: []
    }
  },
  computed: {
    // 根据筛选条件过滤数据
    filteredData() {
      let records = [...this.pagination.records || []];
      
      if (this.filterForm.type) {
        records = records.filter(item => item.type === this.filterForm.type);
      }
      
      if (this.filterForm.institute) {
        records = records.filter(item => item.institute === this.filterForm.institute);
      }
      
      if (this.filterForm.grade) {
        records = records.filter(item => item.grade === this.filterForm.grade);
      }
      
      return records;
    }
  },
  created() {
    this.getExamInfo()
  },
  methods: {
      getExamInfo() { //分页查询所有试卷信息
      const params={}
      if(this.examName) {
        params.examName = this.examName
      }
      this.$axios(`/api/exams/${this.pagination.current}/${this.pagination.size}`
      ,{params}).then(res => {
        this.pagination = res.data.data;
        // 保存原始数据
        this.originalRecords = res.data.data.records || [];
      }).catch(() => {
        this.$message({
          message: '查询失败',
          type: 'error'
        })
      })
    },
    searchExam(){
      this.pagination.current = 1
      this.getExamInfo()
    },
    edit(examCode) { //编辑试卷
      this.dialogVisible = true
      this.$axios(`/api/exam/${examCode}`).then(res => { //根据试卷id请求后台
        if(res.data.code == 200) {
          this.form = res.data.data
        }
      })
    },
    handleClose(done) { //关闭提醒
      this.$confirm('确认关闭？')
        .then(_ => {
          done();
        }).catch(_ => {});
    },
    submit() { //提交修改后的试卷信息
      this.dialogVisible = false
      this.$axios({
        url: '/api/exam',
        method: 'put',
        data: {
          ...this.form
        }
      }).then(res => {
        if(res.data.code == 200) {
          this.$message({ //成功修改提示
            message: '更新成功',
            type: 'success'
          })
        }
        this.getExamInfo()
      })
    },
    deleteRecord(examCode) {
      this.$confirm("确定删除该记录吗,该操作不可逆！！！","删除提示",{
        confirmButtonText: '确定删除',
        cancelButtonText: '算了,留着',
        type: 'danger'
      }).then(()=> { //确认删除
        this.$axios({
          url: `/api/exam/${examCode}`,
          method: 'delete',
        }).then(res => {
          this.getExamInfo()
        })
      }).catch(() => {

      })
    },

    //改变当前记录条数
    handleSizeChange(val) {
      this.pagination.size = val;
      this.getExamInfo();
    },
    //改变当前页码，重新发送请求
    handleCurrentChange(val) {
      this.pagination.current = val;
      this.getExamInfo();
    },
    // 处理筛选
    handleFilter() {
      // 如果需要重新请求API进行筛选，可以在这里实现
      // 目前我们是在前端进行本地筛选
      this.pagination.current = 1; // 重置到第一页
    },
    // 重置筛选条件
    resetFilter() {
      this.filterForm = {
        type: '',
        institute: '',
        grade: ''
      };
      this.pagination.current = 1; // 重置到第一页
    }
  },
};
</script>
<style lang="less" scoped>
.exam {
  padding: 0px 40px;
  
  // 筛选区域样式
  .filter-container {
    background-color: #f5f7fa;
    padding: 16px;
    border-radius: 4px;
    margin-bottom: 20px;
    display: flex;
    align-items: center;
    flex-wrap: wrap;
    gap: 16px;
    
    .filter-item {
      display: flex;
      align-items: center;
      
      .filter-label {
        font-size: 14px;
        color: #606266;
        margin-right: 8px;
        white-space: nowrap;
      }
    }
    
    .filter-action {
      margin-left: auto;
      display: flex;
      gap: 12px;
    }
  }
  
  .page {
    margin-top: 20px;
    display: flex;
    justify-content: center;
    align-items: center;
  }
  
  .edit {
    margin-left: 20px;
  }
}
</style>
