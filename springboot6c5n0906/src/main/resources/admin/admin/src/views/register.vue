<template>
	<div>
		<div class="container" :style='{"minHeight":"100vh","alignItems":"center","background":"url(http://codegen.caihongy.cn/20230823/a87703978f9442fb910c2c0279b4c84c.jpg)","display":"flex","width":"100%","backgroundSize":"cover","backgroundPosition":"center bottom","backgroundRepeat":"no-repeat","justifyContent":"center"}'>
			<el-form v-if="pageFlag=='register'" :style='{"border":"1px solid #f6f6f6","padding":"50px 20px","boxShadow":"0 20px 20px rgba(0, 0, 0, .1)","margin":"20px 0","borderRadius":"20px","textAlign":"center","background":"rgba(255,255,255,1)","width":"650px","height":"auto"}' ref="rgsForm" class="rgs-form" :model="rgsForm" :rules="rules">
				<div v-if="true" :style='{"padding":"0px","margin":"0px auto 30px","borderColor":"#eee","color":"rgba(93, 213, 200, 1)","textAlign":"center","display":"inline-block","background":"none","borderWidth":"0px","width":"100%","lineHeight":"40px","fontSize":"22px","borderStyle":"solid","fontWeight":"600"}' class="title">基于spring boot的快递分拣管理系统注册</div>
				<el-form-item :style='{"padding":"0 0px","margin":"0 auto 15px","textAlign":"left","flexWrap":"wrap","display":"flex","width":"60%","fontSize":"inherit","position":"relative","height":"auto"}' class="list-item" v-if="tableName=='yonghu'">
					<div v-if="true" :style='{"padding":"0 6px","color":"#666","textAlign":"right","left":"-120px","display":"inline-block","width":"120px","lineHeight":"40px","fontSize":"14px","position":"absolute","order":"2"}' class="lable" :class="changeRules('zhanghao')?'required':''">账号：</div>
					<el-input  v-model="ruleForm.zhanghao"  autocomplete="off" placeholder="账号"  type="text"  />
				</el-form-item>
				<el-form-item :style='{"padding":"0 0px","margin":"0 auto 15px","textAlign":"left","flexWrap":"wrap","display":"flex","width":"60%","fontSize":"inherit","position":"relative","height":"auto"}' class="list-item" v-if="tableName=='yonghu'">
					<div v-if="true" :style='{"padding":"0 6px","color":"#666","textAlign":"right","left":"-120px","display":"inline-block","width":"120px","lineHeight":"40px","fontSize":"14px","position":"absolute","order":"2"}' class="lable" :class="changeRules('mima')?'required':''">密码：</div>
					<el-input  v-model="ruleForm.mima"  autocomplete="off" placeholder="密码"  type="password"  />
				</el-form-item>
				<el-form-item :style='{"padding":"0 0px","margin":"0 auto 15px","textAlign":"left","flexWrap":"wrap","display":"flex","width":"60%","fontSize":"inherit","position":"relative","height":"auto"}' class="list-item" v-if="tableName=='yonghu'">
					<div v-if="true" :style='{"padding":"0 6px","color":"#666","textAlign":"right","left":"-120px","display":"inline-block","width":"120px","lineHeight":"40px","fontSize":"14px","position":"absolute","order":"2"}' class="lable" :class="changeRules('mima')?'required':''">确认密码：</div>
					<el-input  v-model="ruleForm.mima2" autocomplete="off" placeholder="确认密码" type="password" />
				</el-form-item>
				<el-form-item :style='{"padding":"0 0px","margin":"0 auto 15px","textAlign":"left","flexWrap":"wrap","display":"flex","width":"60%","fontSize":"inherit","position":"relative","height":"auto"}' class="list-item" v-if="tableName=='yonghu'">
					<div v-if="true" :style='{"padding":"0 6px","color":"#666","textAlign":"right","left":"-120px","display":"inline-block","width":"120px","lineHeight":"40px","fontSize":"14px","position":"absolute","order":"2"}' class="lable" :class="changeRules('xingming')?'required':''">姓名：</div>
					<el-input  v-model="ruleForm.xingming"  autocomplete="off" placeholder="姓名"  type="text"  />
				</el-form-item>
				<el-form-item :style='{"padding":"0 0px","margin":"0 auto 15px","textAlign":"left","flexWrap":"wrap","display":"flex","width":"60%","fontSize":"inherit","position":"relative","height":"auto"}' class="list-item" v-if="tableName=='yonghu'">
					<div v-if="true" :style='{"padding":"0 6px","color":"#666","textAlign":"right","left":"-120px","display":"inline-block","width":"120px","lineHeight":"40px","fontSize":"14px","position":"absolute","order":"2"}' class="lable" :class="changeRules('xingbie')?'required':''">性别：</div>
                    <el-select v-model="ruleForm.xingbie" placeholder="请选择性别" >
                        <el-option
                            v-for="(item,index) in yonghuxingbieOptions"
                            v-bind:key="index"
                            :label="item"
                            :value="item">
                        </el-option>
                    </el-select>
				</el-form-item>
				<el-form-item :style='{"padding":"0 0px","margin":"0 auto 15px","textAlign":"left","flexWrap":"wrap","display":"flex","width":"60%","fontSize":"inherit","position":"relative","height":"auto"}' class="list-item" v-if="tableName=='yonghu'">
					<div v-if="true" :style='{"padding":"0 6px","color":"#666","textAlign":"right","left":"-120px","display":"inline-block","width":"120px","lineHeight":"40px","fontSize":"14px","position":"absolute","order":"2"}' class="lable" :class="changeRules('shouji')?'required':''">手机：</div>
					<el-input  v-model="ruleForm.shouji"  autocomplete="off" placeholder="手机"  type="text"  />
				</el-form-item>
				<el-form-item :style='{"padding":"0 0px","margin":"0 auto 15px","textAlign":"left","flexWrap":"wrap","display":"flex","width":"60%","fontSize":"inherit","position":"relative","height":"auto"}' class="list-item" v-if="tableName=='yonghu'">
					<div v-if="true" :style='{"padding":"0 6px","color":"#666","textAlign":"right","left":"-120px","display":"inline-block","width":"120px","lineHeight":"40px","fontSize":"14px","position":"absolute","order":"2"}' class="lable" :class="changeRules('dizhi')?'required':''">地址：</div>
					<el-input  v-model="ruleForm.dizhi"  autocomplete="off" placeholder="地址"  type="text"  />
				</el-form-item>
				<el-form-item :style='{"padding":"0 0px","margin":"0 auto 15px","textAlign":"left","flexWrap":"wrap","display":"flex","width":"60%","fontSize":"inherit","position":"relative","height":"auto"}' class="list-item" v-if="tableName=='yonghu'">
					<div v-if="true" :style='{"padding":"0 6px","color":"#666","textAlign":"right","left":"-120px","display":"inline-block","width":"120px","lineHeight":"40px","fontSize":"14px","position":"absolute","order":"2"}' class="lable" :class="changeRules('touxiang')?'required':''">头像：</div>
                    <file-upload
                        tip="点击上传头像"
                        action="file/upload"
                        :limit="3"
                        :multiple="true"
                        :fileUrls="ruleForm.touxiang?ruleForm.touxiang:''"
                        @change="yonghutouxiangUploadChange"
                    ></file-upload>
				</el-form-item>
				<button :style='{"border":"0","cursor":"pointer","padding":"0px","boxShadow":"0 0 0px rgba(64, 158, 255, .5)","margin":"30px auto 5px","color":"#fff","display":"block","outline":"none","borderRadius":"0px","background":"#5dd5c8","width":"280px","fontSize":"16px","height":"40px"}' type="button" class="r-btn" @click="login()">注册</button>
				<div :style='{"cursor":"pointer","padding":"0","margin":"10px 0 0","color":"rgba(159, 159, 159, 1)","textAlign":"right","display":"inline-block","width":"60%","lineHeight":"1","fontSize":"14px"}' class="r-login" @click="close()">已有账号，直接登录</div>
			</el-form>
			
		</div>
	</div>
</template>

<script>
export default {
	data() {
		return {
			ruleForm: {
			},
			forgetForm: {},
            pageFlag : '',
			tableName:"",
			rules: {},
            yonghuxingbieOptions: [],
		};
	},
	mounted(){
		this.pageFlag = this.$route.query.pageFlag
		if(this.$route.query.pageFlag=='register'){
			
			let table = this.$storage.get("loginTable");
			this.tableName = table;
			if(this.tableName=='yonghu'){
				this.ruleForm = {
					zhanghao: '',
					mima: '',
					xingming: '',
					xingbie: '',
					shouji: '',
					dizhi: '',
					touxiang: '',
				}
			}
			if ('yonghu' == this.tableName) {
				this.rules.zhanghao = [{ required: true, message: '请输入账号', trigger: 'blur' }]
			}
			if ('yonghu' == this.tableName) {
				this.rules.mima = [{ required: true, message: '请输入密码', trigger: 'blur' }]
			}
			if ('yonghu' == this.tableName) {
				this.rules.xingming = [{ required: true, message: '请输入姓名', trigger: 'blur' }]
			}
			this.yonghuxingbieOptions = "男,女".split(',')
		}
	},
	created() {
	},
	destroyed() {
		  	},
	methods: {
		changeRules(name){
			if(this.rules[name]){
				return true
			}
			return false
		},
		// 获取uuid
		getUUID () {
			return new Date().getTime();
		},
		close(){
			this.$router.push({ path: "/login" });
		},
        yonghutouxiangUploadChange(fileUrls) {
            this.ruleForm.touxiang = fileUrls;
        },

        // 多级联动参数


		// 注册
		login() {
			var url=this.tableName+"/register";
					if((!this.ruleForm.zhanghao) && `yonghu` == this.tableName){
						this.$message.error(`账号不能为空`);
						return
					}
					if((!this.ruleForm.mima) && `yonghu` == this.tableName){
						this.$message.error(`密码不能为空`);
						return
					}
					if((this.ruleForm.mima!=this.ruleForm.mima2) && `yonghu` == this.tableName){
						this.$message.error(`两次密码输入不一致`);
						return
					}
					if((!this.ruleForm.xingming) && `yonghu` == this.tableName){
						this.$message.error(`姓名不能为空`);
						return
					}
					if(`yonghu` == this.tableName && this.ruleForm.shouji &&(!this.$validate.isMobile(this.ruleForm.shouji))){
						this.$message.error(`手机应输入手机格式`);
						return
					}
            if(this.ruleForm.touxiang!=null) {
                this.ruleForm.touxiang = this.ruleForm.touxiang.replace(new RegExp(this.$base.url,"g"),"");
            }
			this.$http({
				url: url,
				method: "post",
				data:this.ruleForm
			}).then(({ data }) => {
				if (data && data.code === 0) {
					this.$message({
						message: "注册成功",
						type: "success",
						duration: 1500,
						onClose: () => {
							this.$router.replace({ path: "/login" });
						}
					});
				} else {
					this.$message.error(data.msg);
				}
			});
		}
	}
};
</script>

<style lang="scss" scoped>
	.container {
	  position: relative;
	  background: url(http://codegen.caihongy.cn/20230823/a87703978f9442fb910c2c0279b4c84c.jpg);

		.el-date-editor.el-input {
		  width: 100%;
		}
		
		.rgs-form .el-input /deep/ .el-input__inner {
						border: 1px solid #eee;
						border-radius: 0px;
						padding: 0 10px;
						box-shadow: 0 0 0px rgba(64, 158, 255, .3);
						outline: none;
						color: #666;
						background: #fff;
						width: 280px;
						font-size: 14px;
						height: 40px;
					}
		
		.rgs-form .el-select /deep/ .el-input__inner {
						border: 1px solid #eee;
						border-radius: 0px;
						padding: 0 10px;
						box-shadow: 0 0 0px rgba(64, 158, 255, .3);
						outline: none;
						color: #666;
						background: #fff;
						width: 280px;
						font-size: 14px;
						height: 40px;
					}
		
		.rgs-form .el-date-editor /deep/ .el-input__inner {
						border: 1px solid #eee;
						border-radius: 0px;
						padding: 0 10px 0 30px;
						box-shadow: 0 0 0px rgba(64, 158, 255, .3);
						outline: none;
						color: #666;
						background: #fff;
						width: 280px;
						font-size: 14px;
						height: 40px;
					}
		
		.rgs-form .el-date-editor /deep/ .el-input__inner {
						border: 1px solid #eee;
						border-radius: 0px;
						padding: 0 10px 0 30px;
						box-shadow: 0 0 0px rgba(64, 158, 255, .3);
						outline: none;
						color: #666;
						background: #fff;
						width: 280px;
						font-size: 14px;
						height: 40px;
					}
		
		.rgs-form /deep/ .el-upload--picture-card {
			background: transparent;
			border: 0;
			border-radius: 0;
			width: auto;
			height: auto;
			line-height: initial;
			vertical-align: middle;
		}
		
		.rgs-form /deep/ .upload .upload-img {
		  		  border: 1px solid #eee;
		  		  cursor: pointer;
		  		  border-radius: 0px;
		  		  color: #999;
		  		  background: #fff;
		  		  width: 160px;
		  		  font-size: 32px;
		  		  line-height: 80px;
		  		  text-align: center;
		  		  height: 80px;
		  		}
		
		.rgs-form /deep/ .el-upload-list .el-upload-list__item {
		  		  border: 1px solid #eee;
		  		  cursor: pointer;
		  		  border-radius: 0px;
		  		  color: #999;
		  		  background: #fff;
		  		  width: 160px;
		  		  font-size: 32px;
		  		  line-height: 80px;
		  		  text-align: center;
		  		  height: 80px;
		  		}
		
		.rgs-form /deep/ .el-upload .el-icon-plus {
		  		  border: 1px solid #eee;
		  		  cursor: pointer;
		  		  border-radius: 0px;
		  		  color: #999;
		  		  background: #fff;
		  		  width: 160px;
		  		  font-size: 32px;
		  		  line-height: 80px;
		  		  text-align: center;
		  		  height: 80px;
		  		}
	}
	.required {
		position: relative;
	}
	.required::after{
				color: red;
				position: absolute;
				right: 3px;
				content: "*";
				order: 3;
			}
	.editor>.avatar-uploader {
		line-height: 0;
		height: 0;
	}
</style>
