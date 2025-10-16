// 添加题库
<template>
  <div class="add">
    <el-tabs v-model="activeName">
    <el-tab-pane name="first">
      <span slot="label"><i class="el-icon-circle-plus"></i>添加试题</span>
      <section class="append">
        <ul>
          <li class="form-row">
            <div class="form-control">
              <span>题目类型:</span>
              <el-select v-model="optionValue" placeholder="请选择题型" class="w150">
                <el-option
                  v-for="item in options"
                  :key="item.value"
                  :label="item.label"
                  :value="item.value">
                </el-option>
              </el-select>
            </div>
            
            <!-- 选择题的正确选项 -->
            <div class="form-control" v-if="optionValue == '选择题'">
              <span>正确选项:</span>
              <el-select v-model="postChange.rightAnswer" placeholder="选择正确答案" class="w150">
                <el-option
                  v-for="item in rights"
                  :key="item.value"
                  :label="item.label"
                  :value="item.value">
                </el-option>
              </el-select>
            </div>
            
            <!-- 选择题的分数 -->
            <div class="form-control" v-if="optionValue == '选择题'">
              <span>分数:</span>
              <el-input
                v-model="postChange.score"
                placeholder="请输入分数"
                class="w150"
                clearable>
              </el-input>
            </div>
            
            <!-- 判断题的分数 -->
            <div class="form-control" v-if="optionValue == '判断题'">
              <span>分数:</span>
              <el-input
                v-model="postJudge.score"
                placeholder="请输入分数"
                class="w150"
                clearable>
              </el-input>
            </div>
            
            <!-- 填空题的分数 -->
            <div class="form-control" v-if="optionValue == '填空题'">
              <span>分数:</span>
              <el-input
                v-model="postFill.score"
                placeholder="请输入分数"
                class="w150"
                clearable>
              </el-input>
            </div>
          </li>
          <!-- <li v-if="optionValue == '选择题'">
            <span>所属章节：</span>
            <el-input
              placeholder="请输入对应章节"
              v-model="postChange.section"
              class="w150"
              clearable>
            </el-input>
          </li>
          <li v-if="optionValue == '填空题'">
            <span>所属章节：</span>
            <el-input
              placeholder="请输入对应章节"
              v-model="postFill.section"
              class="w150"
              clearable>
            </el-input>
          </li>
          <li v-if="optionValue == '判断题'">
            <span>所属章节：</span>
            <el-input
              placeholder="请输入对应章节"
              v-model="postJudge.section"
              class="w150"
              clearable>
            </el-input>
          </li> -->
          <!-- <li v-if="optionValue == '选择题'">
            <span>难度等级:</span>
            <el-select v-model="postChange.level" placeholder="选择难度等级" class="w150">
              <el-option
                v-for="item in levels"
                :key="item.value"
                :label="item.label"
                :value="item.value">
              </el-option>
            </el-select>
          </li>
          <li v-if="optionValue == '填空题'">
            <span>难度等级:</span>
            <el-select v-model="postFill.level" placeholder="选择难度等级" class="w150">
              <el-option
                v-for="item in levels"
                :key="item.value"
                :label="item.label"
                :value="item.value">
              </el-option>
            </el-select>
          </li>
          <li v-if="optionValue == '判断题'">
            <span>难度等级:</span>
            <el-select v-model="postJudge.level" placeholder="选择难度等级" class="w150">
              <el-option
                v-for="item in levels"
                :key="item.value"
                :label="item.label"
                :value="item.value">
              </el-option>
            </el-select>
          </li> -->
  
        </ul>
        <!-- 选择题部分 -->
        <div class="change" v-if="optionValue == '选择题'">
          <div class="title">
            <el-tag>题目:</el-tag><span>在下面的输入框中输入题目,形如--DNS 服务器和DHCP服务器的作用是（）</span>
            <el-input
              type="textarea"
              rows="4"
              v-model="postChange.question"
              placeholder="请输入题目内容"
              resize="none"
              class="answer">
            </el-input>
          </div>
          <div class="options">
            <ul>
              <li>
                <el-tag type="success">A</el-tag>
                <el-input
                  placeholder="请输入选项A的内容"
                  v-model="postChange.answerA"
                  clearable="">
                </el-input>
              </li>
              <li>
                <el-tag type="success">B</el-tag>
                <el-input
                  placeholder="请输入选项B的内容"
                  v-model="postChange.answerB"
                  clearable="">
                </el-input>
              </li>
              <li>
                <el-tag type="success">C</el-tag>
                <el-input
                  placeholder="请输入选项C的内容"
                  v-model="postChange.answerC"
                  clearable="">
                </el-input>
              </li>
              <li>
                <el-tag type="success">D</el-tag>
                <el-input
                  placeholder="请输入选项D的内容"
                  v-model="postChange.answerD"
                  clearable="">
                </el-input>
              </li>
            </ul>
          </div>
          <div class="title">
            <el-tag>解析:</el-tag><span>在下面的输入框中输入题目解析</span>
            <el-input
              type="textarea"
              rows="4"
              v-model="postChange.analysis"
              placeholder="请输入答案解析"
              resize="none"
              class="answer">
            </el-input>
          </div>
          <div class="submit">
            <el-button type="primary" @click="changeSubmit()">立即添加</el-button>
          </div>
        </div>
        <!-- 填空题部分 -->
        <div class="change fill" v-if="optionValue == '填空题'">
          <div class="title">
            <el-tag>题目:</el-tag><span>输入题目,形如--从计算机网络系统组成的角度看，计算机网络可以分为()和()。注意需要考生答题部分一定要用括号（英文半角）括起来。</span>
            <el-input
              type="textarea"
              rows="4"
              v-model="postFill.question"
              placeholder="请输入题目内容"
              resize="none"
              class="answer">
            </el-input>
          </div>
          <div class="fillAnswer">
            <el-tag>正确答案:</el-tag>
            <el-input v-model="postFill.answer"></el-input>
          </div>
          <div class="title analysis">
            <el-tag type="success">解析:</el-tag><span>下方输入框中输入答案解析</span>
            <el-input
              type="textarea"
              rows="4"
              v-model="postFill.analysis"
              placeholder="请输入答案解析"
              resize="none"
              class="answer">
            </el-input>
          </div>
          <div class="submit">
            <el-button type="primary" @click="fillSubmit()">立即添加</el-button>
          </div>
        </div>
        <!-- 判断题 -->
        <div class="change judge" v-if="optionValue == '判断题'">
          <div class="title">
            <el-tag>题目:</el-tag><span>在下面的输入框中输入题目</span>
            <el-input
              type="textarea"
              rows="4"
              v-model="postJudge.question"
              placeholder="请输入题目内容"
              resize="none"
              class="answer">
            </el-input>
          </div>
          <div class="judgeAnswer">
            <el-radio v-model="postJudge.answer" label="T">正确</el-radio>
            <el-radio v-model="postJudge.answer" label="F">错误</el-radio>
          </div>
          <div class="title">
            <el-tag>解析:</el-tag><span>在下面的输入框中输入题目解析</span>
            <el-input
              type="textarea"
              rows="4"
              v-model="postJudge.analysis"
              placeholder="请输入答案解析"
              resize="none"
              class="answer">
            </el-input>
          </div>
          <div class="submit">
            <el-button type="primary" @click="judgeSubmit()">立即添加</el-button>
          </div>
        </div>
      </section>
    </el-tab-pane>
    <el-tab-pane name="second">
      <span slot="label"><i class="iconfont icon-daoru-tianchong"></i>智能组卷</span>

      <div class="box">
        <ul>
          <li class="form-item">
            <div class="form-group">
              <span class="label">选择题</span>
            </div>
            <div class="form-row">
              <div class="form-control">
                <span>知识点范围：</span>
                <el-input type="text" v-model="multiForm.knowledge" placeholder="请输入知识点范围" class="w200"></el-input>
              </div>
              <div class="form-control">
                <span>生成数量：</span>
                <el-input type="number" v-model="multiForm.number" placeholder="请输入数量" class="w120"></el-input>
              </div>
              <div class="form-control">
                <span>每题分值：</span>
                <el-input type="number" v-model="multiForm.score" placeholder="请输入分值" class="w120"></el-input>
              </div>
              <div class="form-control">
                <el-button type="primary" @click="generate(multiForm)" v-loading="loading1">生成</el-button>
              </div>
            </div>
          </li>
          <li class="form-item">
            <div class="form-group">
              <span class="label">填空题</span>
            </div>
            <div class="form-row">
              <div class="form-control">
                <span>知识点范围：</span>
                <el-input type="text" v-model="fillForm.knowledge" placeholder="请输入知识点范围" class="w200"></el-input>
              </div>
              <div class="form-control">
                <span>生成数量：</span>
                <el-input type="number" v-model="fillForm.number" placeholder="请输入数量" class="w120"></el-input>
              </div>
              <div class="form-control">
                <span>每题分值：</span>
                <el-input type="number" v-model="fillForm.score" placeholder="请输入分值" class="w120"></el-input>
              </div>
              <div class="form-control">
                <el-button type="primary" @click="generate(fillForm)" v-loading="loading2">生成</el-button>
              </div>
            </div>
          </li>
          <li class="form-item">
            <div class="form-group">
              <span class="label">判断题</span>
            </div>
            <div class="form-row">
              <div class="form-control">
                <span>知识点范围：</span>
                <el-input type="text" v-model="judgeForm.knowledge" placeholder="请输入知识点范围" class="w200"></el-input>
              </div>
              <div class="form-control">
                <span>生成数量：</span>
                <el-input type="number" v-model="judgeForm.number" placeholder="请输入数量" class="w120"></el-input>
              </div>
              <div class="form-control">
                <span>每题分值：</span>
                <el-input type="number" v-model="judgeForm.score" placeholder="请输入分值" class="w120"></el-input>
              </div>
              <div class="form-control">
                <el-button type="primary" @click="generate(judgeForm)" v-loading="loading3">生成</el-button>
              </div>
            </div>
          </li>
        </ul>
      </div>

    </el-tab-pane>
  </el-tabs>
  </div>
</template>

<script>
export default {
  data() {
    return {
      loading1: false,
      loading2: false,
      loading3: false,
      generateForm: {
        paperId: null, //试卷id
        subject: '', //试卷科目
        type: '', //试卷类型
        knowledge: '', //选择题知识点范围
        number: null, //选择题出题数量
        score: null, //选择题每题分值
      }, //提交的生成表单数据
      multiForm: {
        paperId: null, //试卷id
        subject: '', //试卷科目
        type: '选择题', //试卷类型
        knowledge: '高等数学', //选择题知识点范围
        number: 1, //选择题出题数量
        score: 1, //选择题每题分值
      }, //提交的选择题表单数据
      fillForm: {
        paperId: null, //试卷id
        subject: '', //试卷科目
        type: '填空题', //试卷类型
        knowledge: '大学英语', //填空题知识点范围
        number: 1, //填空题出题数量
        score: 1, //填空题每题分值
      }, //提交的填空题表单数据
      judgeForm: {
        paperId: null, //试卷id
        subject: '', //试卷科目
        type: '判断题', //试卷类型
        knowledge: '大学物理', //判断题知识点范围
        number: 1, //判断题出题数量
        score: 1, //判断题每题分值
      }, //提交的判断题表单数据
      activeName: 'first',  //活动选项卡
      options: [ //题库类型
        {
          value: '选择题',
          label: '选择题'
        },
        {
          value: '填空题',
          label: '填空题'
        },
        {
          value: '判断题',
          label: '判断题'
        },
      ],
      difficulty: [ //试题难度
        {
          value: '简单',
          label: '简单'
        },
        {
          value: '一般',
          label: '一般'
        },
        {
          value: '困难',
          label: '困难'
        }
      ],
      difficultyValue: '简单',
      levels: [ //难度等级
        {
          value: '1',
          label: '1'
        },
        {
          value: '2',
          label: '2'
        },
        {
          value: '3',
          label: '3'
        },
        {
          value: '4',
          label: '4'
        },
        {
          value: '5',
          label: '5'
        },
      ],
      rights: [ //正确答案
        {
          value: 'A',
          label: 'A'
        },
        {
          value: 'B',
          label: 'B'
        },
        {
          value: 'C',
          label: 'C'
        },
        {
          value: 'D',
          label: 'D'
        },
      ],
      paperId: null,
      optionValue: '选择题', //题型选中值
      subject: '', //试卷名称用来接收路由参数
      postChange: { //选择题提交内容
        subject: '', //试卷名称
        level: '', //难度等级选中值 
        rightAnswer: '', //正确答案选中值
        section: '', //对应章节
        question: '', //题目
        analysis: '', //解析
        answerA: '',
        answerB: '',
        answerC: '',
        answerD: '',
        score: null, //分数
      },
      postFill: { //填空题提交内容
        subject: '', //试卷名称
        level: '', //难度等级选中值 
        answer: '', //正确答案
        section: '', //对应章节
        question: '', //题目
        analysis: '', //解析
        score: null, //分数
      },
      postJudge: { //判断题提交内容
        subject: '', //试卷名称
        level: '', //难度等级选中值 
        answer: '', //正确答案
        section: '', //对应章节
        question: '', //题目
        analysis: '', //解析
        score: null, //分数
      },
      postPaper: { //考试管理表对应字段
        paperId: null,
        questionType: null, // 试卷类型 1--选择题  2--填空题   3--判断题
        questionId: null,
      }
    };
  },
  created() {
    this.getParams()
  },
  methods: {
    // handleClick(tab, event) {
    //   console.log(tab, event);
    // },
     generate(form){
      console.log(form)
        if(form.type == '选择题'){
          this.loading1 = true
        }else if(form.type == '填空题'){
          this.loading2 = true
        }else if(form.type == '判断题'){
          this.loading3 = true
        }
      this.generateForm.paperId = this.paperId
      this.generateForm.subject = this.subject
      this.generateForm.type = form.type
      this.generateForm.knowledge = form.knowledge
      this.generateForm.number = form.number
      this.generateForm.score = form.score
      this.$axios('/api/chat',{
        method: 'post',
        data: this.generateForm
      })
      .then(res => {
        let data = res.data
        if(Number(data.code)==200){
          this.$message.success(form.type+"生成成功")
        }else if(data.code==400){
          this.$message.error(form.type+"生成失败")
        }
        if(form.type == '选择题'){
          this.loading1 = false
        }else if(form.type == '填空题'){
          this.loading2 = false
        }else if(form.type == '判断题'){
          this.loading3 = false
        }
      })
    },
    create() {
      this.$axios({
        url: '/api/item',
        method: 'post',
        data: {
          changeNumber: this.changeNumber,
          fillNumber: this.fillNumber,
          judgeNumber: this.judgeNumber,
          paperId: this.paperId,
          subject: '计算机网络' //题目数量太少，指定为计算机网络出题
        }
      }).then(res => {
        console.log(res)
        let data = res.data
        if(data.code==200){
          setTimeout(() => {
            this.$router.push({path: '/selectAnswer'})
          },1000)
           this.$message({
            message: data.message,
            type: 'success'
          })
        }else if(data.code==400){
            this.$message({
            message: data.message,
            type: 'error'
          })
        }

      })
    },
    getParams() {
      let subject = this.$route.query.subject //获取试卷名称
      let paperId = this.$route.query.paperId //获取paperId
      this.paperId = paperId
      this.subject = subject
      this.postPaper.paperId = paperId
    },
    changeSubmit() { //选择题题库提交
      this.postChange.subject = this.subject
      this.$axios({ //提交数据到选择题题库表
        url: '/api/MultiQuestion',
        method: 'post',
        data: {
          ...this.postChange          
        }
      }).then(res => { //添加成功显示提示
        let status = res.data.code
        if(status == 200) {
          this.$message({
            message: '已添加到题库',
            type: 'success'
          })
          this.postChange = {}
        }
      }).then(() => {
        this.$axios(`/api/multiQuestionId`).then(res => { //获取当前题目的questionId
          let questionId = res.data.data.questionId
          this.postPaper.questionId = questionId
          this.postPaper.questionType = 1
          this.$axios({
            url: '/api/paperManage',
            method: 'Post',
            data: {
              ...this.postPaper
            }
          })
        })
      })
    },
    fillSubmit() { //填空题提交
      this.postFill.subject = this.subject
      this.$axios({
        url: '/api/fillQuestion',
        method: 'post',
        data: {
          ...this.postFill
        }
      }).then(res => {
        let status = res.data.code
        if(status == 200) {
          this.$message({
            message: '已添加到题库',
            type: 'success'
          })
          this.postFill = {}
        }
      }).then(() => {
        this.$axios(`/api/fillQuestionId`).then(res => { //获取当前题目的questionId
          let questionId = res.data.data.questionId
          this.postPaper.questionId = questionId
          this.postPaper.questionType = 2
          this.$axios({
            url: '/api/paperManage',
            method: 'Post',
            data: {
              ...this.postPaper
            }
          })
        })
      })
    },
    judgeSubmit() { //判断题提交
      this.postJudge.subject = this.subject
      this.$axios({
        url: '/api/judgeQuestion',
        method: 'post',
        data: {
          ...this.postJudge
        }
      }).then(res => {
        let status = res.data.code
        if(status == 200) {
          this.$message({
            message: '已添加到题库',
            type: 'success'
          })
          this.postJudge = {}
        }
      }).then(() => {
        this.$axios(`/api/judgeQuestionId`).then(res => { //获取当前题目的questionId
          let questionId = res.data.data.questionId
          this.postPaper.questionId = questionId
          this.postPaper.questionType = 3
          this.$axios({
            url: '/api/paperManage',
            method: 'Post',
            data: {
              ...this.postPaper
            }
          })
        })
      })
    }
  },
};
</script>

<style scoped>
.add {
  padding: 20px;
}

.append {
  padding: 20px;
}

.append ul {
  margin: 0;
  padding: 0;
}

.append li {
  margin-bottom: 20px;
  list-style: none;
}

.append li span {
  margin-right: 10px;
}

.answer {
  width: 100%;
  margin-top: 10px;
}

.change {
  margin-top: 20px;
  border: 1px solid #e6e6e6;
  padding: 20px;
  border-radius: 5px;
}

.title {
  margin-bottom: 20px;
}

.title span {
  margin-left: 10px;
  color: #909399;
}

.options {
  margin-bottom: 20px;
}

.options ul {
  margin: 0;
  padding: 0;
}

.options li {
  margin-bottom: 15px;
  list-style: none;
  display: flex;
  align-items: center;
}

.options li .el-tag {
  margin-right: 10px;
}

.fillAnswer {
  margin-bottom: 20px;
  display: flex;
  align-items: center;
}

.fillAnswer .el-tag {
  margin-right: 10px;
}

.judgeAnswer {
  margin-bottom: 20px;
}

.submit {
  margin-top: 20px;
  text-align: center;
}

.box {
  padding: 20px;
  background: #f5f7fa;
  border-radius: 6px;
}

.box ul {
  margin: 0;
  padding: 0;
}

.form-item {
  margin-bottom: 25px;
  padding: 15px;
  background: #fff;
  border-radius: 6px;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.05);
}

.form-group {
  margin-bottom: 15px;
  padding-bottom: 10px;
  border-bottom: 1px solid #e6e6e6;
}

.form-group .label {
  font-size: 16px;
  font-weight: 500;
  color: #303133;
}

.form-row {
  display: flex;
  flex-wrap: wrap;
  align-items: center;
  gap: 20px;
}

.form-control {
  display: flex;
  align-items: center;
  gap: 8px;
}

.form-control span {
  white-space: nowrap;
  color: #606266;
  font-size: 14px;
}

.w200 {
  width: 200px;
}

.w150 {
  width: 150px;
}

.w120 {
  width: 120px;
}

.w100 {
  width: 100px;
}

/* 调整输入框和按钮的间距 */
.el-input {
  margin-right: 10px;
}

.el-button {
  margin-left: 10px;
}

</style>


