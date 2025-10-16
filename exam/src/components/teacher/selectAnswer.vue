//查询所有题库
<template>
  <div class="exam">
        <!-- 筛选区域 -->
    <div class="filter-container">
      <div class="filter-item">
        <span class="filter-label" >试卷名称：</span>
        <el-select v-model="subject" placeholder="请选择试卷名称" @change="searchChange()">
          <el-option v-for="item in examList" :key="item" :label="item" :value="item"></el-option>
        </el-select>
        <el-select v-model="type" placeholder="请选择试卷类型" @change="searchChange()">
          <el-option v-for="item in examTypeList" :key="item" :label="item" :value="item"></el-option>
        </el-select>
         <div class="filter-action">
        <el-button type="primary" @click="resetSearch()">重置筛选</el-button>
      </div>
    </div>
    </div>

    <el-table :data="pagination.records" border :row-class-name="tableRowClassName">
      <el-table-column fixed="left" prop="subject" label="试卷名称" width="180"></el-table-column>
      <el-table-column prop="questionId" label="题目编号" width="490" v-if="false"></el-table-column>
      <el-table-column prop="type" label="题目类型" width="200"></el-table-column>
      <el-table-column prop="question" label="题目信息" width="490"></el-table-column>
      <el-table-column prop="score" label="试题分数" width="150"></el-table-column>
      <el-table-column prop="section" label="所属章节" width="200"></el-table-column>
      <!-- <el-table-column prop="level" label="难度等级" width="133"></el-table-column> -->
      <el-table-column fixed="right" label="操作" width="150">
        <template slot-scope="scope">
          <el-button @click="editAnswer(scope.row)" type="primary" size="small">编辑</el-button>
          <el-button @click="deleteAnswer(scope.row)" type="danger" size="small">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    <el-pagination
      @size-change="handleSizeChange"
      @current-change="handleCurrentChange"
      :current-page="pagination.current"
      :page-sizes="[6, 10]"
      :page-size="pagination.size"
      layout="total, sizes, prev, pager, next, jumper"
      :total="pagination.total"
      class="page"
    ></el-pagination>
    
    <!-- 编辑弹窗 -->
    <el-dialog
      title="编辑题库信息"
      :visible.sync="dialogVisible"
      width="50%"
      :before-close="handleClose"
    >
      <el-form :model="form" ref="form" label-width="120px">
        <!-- 题目编号（不可编辑） -->
        <el-form-item label="题目编号" prop="questionId">
          <el-input v-model="form.questionId" disabled placeholder="题目编号"></el-input>
        </el-form-item>
        
        <!-- 通用字段 -->
        <el-form-item label="考试科目" prop="subject">
          <el-input v-model="form.subject" placeholder="请输入考试科目"></el-input>
        </el-form-item>
        <el-form-item label="试题内容" prop="question">
          <el-input v-model="form.question" type="textarea" :rows="3" placeholder="请输入试题内容"></el-input>
        </el-form-item>
        <el-form-item label="所属章节" prop="section">
          <el-input v-model="form.section" placeholder="请输入所属章节"></el-input>
        </el-form-item>
        <!-- <el-form-item label="难度等级" prop="level">
          <el-input v-model="form.level" placeholder="请输入难度等级"></el-input>
        </el-form-item> -->
        <el-form-item label="题目解析" prop="analysis">
          <el-input v-model="form.analysis" type="textarea" :rows="2" placeholder="请输入题目解析"></el-input>
        </el-form-item>
        <el-form-item label="试题分数" prop="score">
          <el-input v-model.number="form.score" type="number" placeholder="请输入试题分数"></el-input>
        </el-form-item>
        
        <!-- 选择题特有字段 -->
        <template v-if="form.type === '选择题'">
          <el-form-item label="选项A" prop="answerA">
            <el-input v-model="form.answerA" placeholder="请输入选项A"></el-input>
          </el-form-item>
          <el-form-item label="选项B" prop="answerB">
            <el-input v-model="form.answerB" placeholder="请输入选项B"></el-input>
          </el-form-item>
          <el-form-item label="选项C" prop="answerC">
            <el-input v-model="form.answerC" placeholder="请输入选项C"></el-input>
          </el-form-item>
          <el-form-item label="选项D" prop="answerD">
            <el-input v-model="form.answerD" placeholder="请输入选项D"></el-input>
          </el-form-item>
          <el-form-item label="正确答案" prop="rightAnswer">
            <el-input v-model="form.rightAnswer" placeholder="请输入正确答案（如：A或AB）"></el-input>
          </el-form-item>
        </template>
        
        <!-- 判断题特有字段 -->
        <template v-else-if="form.type === '判断题'">
          <el-form-item label="正确答案" prop="answer">
            <el-select v-model="form.answer" placeholder="请选择正确答案">
              <el-option label="正确" value="正确"></el-option>
              <el-option label="错误" value="错误"></el-option>
            </el-select>
          </el-form-item>
        </template>
        
        <!-- 填空题特有字段 -->
        <template v-else-if="form.type === '填空题'">
          <el-form-item label="正确答案" prop="answer">
            <el-input v-model="form.answer" type="textarea" :rows="2" placeholder="请输入正确答案"></el-input>
          </el-form-item>
        </template>
      </el-form>

      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogVisible = false">取消</el-button>
        <el-button type="primary" @click="submitForm()">确定</el-button>
      </div>
    </el-dialog>
    
    <!-- 删除确认对话框 -->
    <el-dialog
      title="提示"
      :visible.sync="deleteDialogVisible"
      width="30%"
      :show-close="false"
    >
      <span>确定要删除该题库信息吗？</span>
      <span slot="footer" class="dialog-footer">
        <el-button @click="deleteDialogVisible = false">取消</el-button>
        <el-button type="danger" @click="confirmDelete">确定</el-button>
      </span>
    </el-dialog>
  </div>
</template>

<script>
export default {
  data() {
    return {
      subject: '',
      type: '',
      examTypeList: ['选择题','填空题','判断题'],
      examList: [],
      pagination: {
        //分页后的考试信息
        current: 1, //当前页
        total: null, //记录条数
        size: 6 //每页条数
      },
      dialogVisible: false, // 编辑弹窗显示状态
      deleteDialogVisible: false, // 删除确认弹窗显示状态
      currentRow: null, // 当前操作的行数据
      form: {},
    };
  },
  created() {
    this.getExamNameList();
    this.getAnswerInfo();
  },
  methods: {
    getExamNameList(){
      //获取所有试卷名称
      this.$axios(
        `/api/answer/examName`
      )
        .then(res => {
          this.examList = res.data.data;
        })
        .catch(error => {
          this.$message.error('获取试卷名称失败');
        });
    },
    getAnswerInfo() {
      const params={}
      if(this.subject){
        params.subject = this.subject;
      }
      if(this.type){
        params.type = this.type;
      }
      //分页查询所有试卷信息
      this.$axios(
        `/api/answers/${this.pagination.current}/${this.pagination.size}`,
        {params}
      )
        .then(res => {
          this.pagination = res.data.data;
          console.log(res);
        })
        .catch(error => {});
    },
    searchChange(){
      this.pagination.current = 1;
      this.getAnswerInfo();
    },
    resetSearch(){
      this.subject = '';
      this.type = '';
      this.getAnswerInfo();
    },
    //改变当前记录条数
    handleSizeChange(val) {
      this.pagination.size = val;
      this.getAnswerInfo();
    },
    //改变当前页码，重新发送请求
    handleCurrentChange(val) {
      this.pagination.current = val;
      this.getAnswerInfo();
    },
    tableRowClassName({ row, rowIndex }) {
      if (rowIndex % 2 == 0) {
        return "warning-row";
      } else {
        return "success-row";
      }
    },
    // 编辑功能
    editAnswer(row) {
      console.log(row);
      const params={}
      if(row.type){
        params.type = row.type;
      }
      if(row.questionId){
        params.questionId = row.questionId;
      }
      this.$axios( '/api/answer',{params})
        .then(res => {
          this.form = res.data.data;
          this.form.type = row.type;
        })
        .catch(error => {
          this.$message.error('获取题库信息失败');
        });
      this.dialogVisible = true;
    },
    // 关闭弹窗时重置表单
    handleClose() {
      // 显示确认对话框
      this.$confirm('确认关闭？', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        // 用户确认关闭
        this.dialogVisible = false;
        this.$refs.form.resetFields();
      }).catch(() => {
        // 用户取消关闭
        this.$message.info('已取消关闭');
      });
    },
    // 提交编辑表单
    submitForm() {
          // 这里用户自己实现API调用
          console.log('提交的表单数据:', this.form);
          // API调用代码由用户实现
          this.$axios(
            `/api/answer`,
            {method: 'put',data: this.form}
          )
          // 调用成功后关闭弹窗并刷新数据
          this.dialogVisible = false;
          this.$message.success('编辑成功');
          this.getAnswerInfo();
        },
    // 删除功能
    deleteAnswer(row) {
      this.currentRow = row;
      this.deleteDialogVisible = true;
    },
    // 确认删除
    async confirmDelete() {
      const params={}
      if(this.currentRow.type){
        console.log(this.currentRow.type);
        params.type = this.currentRow.type;
      }
      if(this.currentRow.questionId){
        params.questionId = this.currentRow.questionId;
      }
      // 这里用户自己实现API调用
      console.log('要删除的数据:', this.currentRow);
      // API调用代码由用户实现
      await this.$axios(
        `/api/answer`,
        {method: 'delete',params}
      )
      // 调用成功后关闭弹窗并刷新数据
      this.deleteDialogVisible = false;
      this.$message.success('删除成功');
      this.getAnswerInfo();
    }
  }
};
</script>
<style lang="less" scoped>
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
.exam {
  padding: 0px 40px;
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
/* 修复表格样式，确保内容可读性 */
.el-table {
  .el-table__row {
    background-color: #ffffff !important;
    color: #333333;
  }
  .warning-row {
    background: #f5f7fa !important;
  }
  .success-row {
    background: #e6f7ff !important;
  }
  th {
    background-color: #f0f2f5 !important;
    color: #606266 !important;
    font-weight: 500 !important;
  }
}
</style>
