<template>
	<div class="addEdit-block" :style='{"padding":"30px","fontSize":"14px","color":"#666","background":"none"}'>
		<el-form
			:style='{"border":"1px solid rgba(255,255,255,1)","padding":"30px","borderRadius":"4px","alignItems":"flex-start","flexWrap":"wrap","background":"rgba(255,255,255,.8)","display":"flex","fontSize":"inherit"}'
			class="add-update-preview"
			ref="ruleForm"
			:model="ruleForm"
			:rules="rules"
			label-width="150px"
		>
			<template >
				<el-form-item :style='{"width":"100%","margin":"0 0 30px 0","fontSize":"inherit","color":"inherit"}' class="input" v-if="type!='info'" label="路线编号" prop="luxianbianhao">
					<el-input v-model="ruleForm.luxianbianhao" placeholder="路线编号" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"100%","margin":"0 0 30px 0","fontSize":"inherit","color":"inherit"}' class="input" v-else-if="ruleForm.luxianbianhao" label="路线编号" prop="luxianbianhao">
					<el-input v-model="ruleForm.luxianbianhao" placeholder="路线编号" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"100%","margin":"0 0 30px 0","fontSize":"inherit","color":"inherit"}' class="input" v-if="type!='info'"  label="路线名称" prop="luxianmingcheng">
					<el-input v-model="ruleForm.luxianmingcheng" placeholder="路线名称" clearable  :readonly="ro.luxianmingcheng"></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"100%","margin":"0 0 30px 0","fontSize":"inherit","color":"inherit"}' v-else class="input" label="路线名称" prop="luxianmingcheng">
					<el-input v-model="ruleForm.luxianmingcheng" placeholder="路线名称" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"100%","margin":"0 0 30px 0","fontSize":"inherit","color":"inherit"}' class="input" v-if="type!='info'"  label="起点" prop="qidian">
					<el-input v-model="ruleForm.qidian" placeholder="起点" clearable  :readonly="ro.qidian"></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"100%","margin":"0 0 30px 0","fontSize":"inherit","color":"inherit"}' v-else class="input" label="起点" prop="qidian">
					<el-input v-model="ruleForm.qidian" placeholder="起点" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"100%","margin":"0 0 30px 0","fontSize":"inherit","color":"inherit"}' class="input" v-if="type!='info'"  label="终点" prop="zhongdian">
					<el-input v-model="ruleForm.zhongdian" placeholder="终点" clearable  :readonly="ro.zhongdian"></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"100%","margin":"0 0 30px 0","fontSize":"inherit","color":"inherit"}' v-else class="input" label="终点" prop="zhongdian">
					<el-input v-model="ruleForm.zhongdian" placeholder="终点" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"100%","margin":"0 0 30px 0","fontSize":"inherit","color":"inherit"}' class="input" v-if="type!='info'"  label="路线距离" prop="luxianjuli">
					<el-input v-model="ruleForm.luxianjuli" placeholder="路线距离" clearable  :readonly="ro.luxianjuli"></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"100%","margin":"0 0 30px 0","fontSize":"inherit","color":"inherit"}' v-else class="input" label="路线距离" prop="luxianjuli">
					<el-input v-model="ruleForm.luxianjuli" placeholder="路线距离" readonly></el-input>
				</el-form-item>
			</template>
				<el-form-item :style='{"width":"100%","margin":"0 0 30px 0","fontSize":"inherit","color":"inherit"}' class="textarea" v-if="type!='info'" label="途径站点" prop="tujingzhandian">
					<el-input
					  style="min-width: 200px; max-width: 600px;"
					  type="textarea"
					  :rows="8"
					  placeholder="途径站点"
					  v-model="ruleForm.tujingzhandian" >
					</el-input>
				</el-form-item>
				<el-form-item :style='{"width":"100%","margin":"0 0 30px 0","fontSize":"inherit","color":"inherit"}' v-else-if="ruleForm.tujingzhandian" label="途径站点" prop="tujingzhandian">
					<span :style='{"fontSize":"14px","lineHeight":"40px","color":"inherit","fontWeight":"500","display":"inline-block"}'>{{ruleForm.tujingzhandian}}</span>
				</el-form-item>
				<el-form-item :style='{"width":"100%","margin":"0 0 30px 0","fontSize":"inherit","color":"inherit"}' v-if="type!='info'"  label="路线详情" prop="luxianxiangqing">
					<editor 
						style="min-width: 200px; max-width: 600px;"
						v-model="ruleForm.luxianxiangqing" 
						class="editor" 
						action="file/upload">
					</editor>
				</el-form-item>
				<el-form-item :style='{"width":"100%","margin":"0 0 30px 0","fontSize":"inherit","color":"inherit"}' v-else-if="ruleForm.luxianxiangqing" label="路线详情" prop="luxianxiangqing">
                    <span :style='{"fontSize":"14px","lineHeight":"40px","color":"inherit","fontWeight":"500","display":"inline-block"}' v-html="ruleForm.luxianxiangqing"></span>
                </el-form-item>
			<el-form-item :style='{"padding":"0","margin":"30px 0","alignItems":"center","textAlign":"center","display":"flex","width":"100%","perspective":"320px","-webkitPerspective":"320px","fontSize":"48px","justifyContent":"center"}' class="btn">
				<el-button class="btn3"  v-if="type!='info'" type="success" @click="onSubmit">
					<span class="icon iconfont icon-tijiao16" :style='{"color":"inherit","margin":"0 2px","fontSize":"18px"}'></span>
					提交
				</el-button>
				<el-button class="btn4" v-if="type!='info'" type="success" @click="back()">
					<span class="icon iconfont icon-quxiao09" :style='{"color":"inherit","margin":"0 2px","fontSize":"18px"}'></span>
					取消
				</el-button>
				<el-button class="btn5" v-if="type=='info'" type="success" @click="back()">
					<span class="icon iconfont icon-fanhui01" :style='{"color":"inherit","margin":"0 2px","fontSize":"18px"}'></span>
					返回
				</el-button>
			</el-form-item>
		</el-form>
    

  </div>
</template>
<script>
export default {
	data() {
		return {
			id: '',
			type: '',
			
			
			ro:{
				luxianbianhao : false,
				luxianmingcheng : false,
				qidian : false,
				tujingzhandian : false,
				zhongdian : false,
				luxianjuli : false,
				luxianxiangqing : false,
			},
			
			
			ruleForm: {
				luxianbianhao: this.getUUID(),
				luxianmingcheng: '',
				qidian: '',
				tujingzhandian: '',
				zhongdian: '',
				luxianjuli: '',
				luxianxiangqing: '',
			},
		

			
			rules: {
				luxianbianhao: [
				],
				luxianmingcheng: [
				],
				qidian: [
				],
				tujingzhandian: [
				],
				zhongdian: [
				],
				luxianjuli: [
				],
				luxianxiangqing: [
				],
			},
		};
	},
	props: ["parent"],
	computed: {



	},
    components: {
    },
	created() {
	},
	methods: {
		
		// 下载
		download(file){
			window.open(`${file}`)
		},
		// 初始化
		init(id,type) {
			if (id) {
				this.id = id;
				this.type = type;
			}
			if(this.type=='info'||this.type=='else'){
				this.info(id);
			}else if(this.type=='logistics'){
				this.logistics=false;
				this.info(id);
			}else if(this.type=='cross'){
				var obj = this.$storage.getObj('crossObj');
				for (var o in obj){
						if(o=='luxianbianhao'){
							this.ruleForm.luxianbianhao = obj[o];
							this.ro.luxianbianhao = true;
							continue;
						}
						if(o=='luxianmingcheng'){
							this.ruleForm.luxianmingcheng = obj[o];
							this.ro.luxianmingcheng = true;
							continue;
						}
						if(o=='qidian'){
							this.ruleForm.qidian = obj[o];
							this.ro.qidian = true;
							continue;
						}
						if(o=='tujingzhandian'){
							this.ruleForm.tujingzhandian = obj[o];
							this.ro.tujingzhandian = true;
							continue;
						}
						if(o=='zhongdian'){
							this.ruleForm.zhongdian = obj[o];
							this.ro.zhongdian = true;
							continue;
						}
						if(o=='luxianjuli'){
							this.ruleForm.luxianjuli = obj[o];
							this.ro.luxianjuli = true;
							continue;
						}
						if(o=='luxianxiangqing'){
							this.ruleForm.luxianxiangqing = obj[o];
							this.ro.luxianxiangqing = true;
							continue;
						}
				}
			}
			// 获取用户信息
			this.$http({
				url: `${this.$storage.get('sessionTable')}/session`,
				method: "get"
			}).then(({ data }) => {
				if (data && data.code === 0) {
					var json = data.data;
				} else {
					this.$message.error(data.msg);
				}
			});
			
		},
    // 多级联动参数

    info(id) {
      this.$http({
        url: `luxianxinxi/info/${id}`,
        method: "get"
      }).then(({ data }) => {
        if (data && data.code === 0) {
        this.ruleForm = data.data;
        //解决前台上传图片后台不显示的问题
        let reg=new RegExp('../../../upload','g')//g代表全部
        this.ruleForm.luxianxiangqing = this.ruleForm.luxianxiangqing.replace(reg,'../../../springboot6c5n0906/upload');
        } else {
          this.$message.error(data.msg);
        }
      });
    },


    // 提交
    onSubmit() {
		if(this.ruleForm.luxianbianhao) {
			this.ruleForm.luxianbianhao = String(this.ruleForm.luxianbianhao)
		}
var objcross = this.$storage.getObj('crossObj');
      //更新跨表属性
       var crossuserid;
       var crossrefid;
       var crossoptnum;
       if(this.type=='cross'){
                var statusColumnName = this.$storage.get('statusColumnName');
                var statusColumnValue = this.$storage.get('statusColumnValue');
                if(statusColumnName!='') {
                        var obj = this.$storage.getObj('crossObj');
                       if(statusColumnName && !statusColumnName.startsWith("[")) {
                               for (var o in obj){
                                 if(o==statusColumnName){
                                   obj[o] = statusColumnValue;
                                 }
                               }
                               var table = this.$storage.get('crossTable');
                             this.$http({
                                 url: `${table}/update`,
                                 method: "post",
                                 data: obj
                               }).then(({ data }) => {});
                       } else {
                               crossuserid=this.$storage.get('userid');
                               crossrefid=obj['id'];
                               crossoptnum=this.$storage.get('statusColumnName');
                               crossoptnum=crossoptnum.replace(/\[/,"").replace(/\]/,"");
                        }
                }
        }
		this.$refs["ruleForm"].validate(valid => {
			if (valid) {
				if(crossrefid && crossuserid) {
					this.ruleForm.crossuserid = crossuserid;
					this.ruleForm.crossrefid = crossrefid;
					let params = { 
						page: 1, 
						limit: 10, 
						crossuserid:this.ruleForm.crossuserid,
						crossrefid:this.ruleForm.crossrefid,
					} 
				this.$http({ 
					url: "luxianxinxi/page", 
					method: "get", 
					params: params 
				}).then(({ 
					data 
				}) => { 
					if (data && data.code === 0) { 
						if(data.data.total>=crossoptnum) {
							this.$message.error(this.$storage.get('tips'));
							return false;
						} else {
							this.$http({
								url: `luxianxinxi/${!this.ruleForm.id ? "save" : "update"}`,
								method: "post",
								data: this.ruleForm
							}).then(({ data }) => {
								if (data && data.code === 0) {
									this.$message({
										message: "操作成功",
										type: "success",
										duration: 1500,
										onClose: () => {
											this.parent.showFlag = true;
											this.parent.addOrUpdateFlag = false;
											this.parent.luxianxinxiCrossAddOrUpdateFlag = false;
											this.parent.search();
											this.parent.contentStyleChange();
										}
									});
								} else {
									this.$message.error(data.msg);
								}
							});

						}
					} else { 
				} 
			});
		} else {
			this.$http({
				url: `luxianxinxi/${!this.ruleForm.id ? "save" : "update"}`,
				method: "post",
			   data: this.ruleForm
			}).then(({ data }) => {
				if (data && data.code === 0) {
					this.$message({
						message: "操作成功",
						type: "success",
						duration: 1500,
						onClose: () => {
							this.parent.showFlag = true;
							this.parent.addOrUpdateFlag = false;
							this.parent.luxianxinxiCrossAddOrUpdateFlag = false;
							this.parent.search();
							this.parent.contentStyleChange();
						}
					});
				} else {
					this.$message.error(data.msg);
			   }
			});
		 }
         }
		});
    },
    // 获取uuid
    getUUID () {
      return new Date().getTime();
    },
    // 返回
    back() {
      this.parent.showFlag = true;
      this.parent.addOrUpdateFlag = false;
      this.parent.luxianxinxiCrossAddOrUpdateFlag = false;
      this.parent.contentStyleChange();
    },
  }
};
</script>
<style lang="scss" scoped>
	.amap-wrapper {
		width: 100%;
		height: 500px;
	}
	
	.search-box {
		position: absolute;
	}
	
	.el-date-editor.el-input {
		width: auto;
	}
	
	.add-update-preview .el-form-item /deep/ .el-form-item__label {
	  	  padding: 0 10px 0 0;
	  	  color: inherit;
	  	  font-weight: 500;
	  	  display: inline-block;
	  	  width: 150px;
	  	  font-size: inherit;
	  	  line-height: 40px;
	  	  text-align: right;
	  	}
	
	.add-update-preview .el-form-item /deep/ .el-form-item__content {
	  margin-left: 150px;
	}
	
	.add-update-preview .el-input /deep/ .el-input__inner {
	  	  border: 1px solid #ddd;
	  	  border-radius: 0px;
	  	  padding: 0 12px;
	  	  box-shadow: 0 0 0px rgba(64, 158, 255, .5);
	  	  outline: none;
	  	  color: inherit;
	  	  background: #fff;
	  	  width: auto;
	  	  font-size: 14px;
	  	  min-width: 350px;
	  	  height: 36px;
	  	}
	.add-update-preview .el-input-number /deep/ .el-input__inner {
		text-align: left;
	  	  border: 1px solid #ddd;
	  	  border-radius: 0px;
	  	  padding: 0 12px;
	  	  box-shadow: 0 0 0px rgba(64, 158, 255, .5);
	  	  outline: none;
	  	  color: inherit;
	  	  background: #fff;
	  	  width: auto;
	  	  font-size: 14px;
	  	  min-width: 350px;
	  	  height: 36px;
	  	}
	.add-update-preview .el-input-number /deep/ .el-input-number__decrease {
		display: none;
	}
	.add-update-preview .el-input-number /deep/ .el-input-number__increase {
		display: none;
	}
	
	.add-update-preview .el-select /deep/ .el-input__inner {
	  	  border: 1px solid #ddd;
	  	  border-radius: 0px;
	  	  padding: 0 10px;
	  	  box-shadow: 0 0 0px rgba(64, 158, 255, .5);
	  	  outline: none;
	  	  color: inherit;
	  	  background: #fff;
	  	  width: auto;
	  	  font-size: 14px;
	  	  height: 36px;
	  	}
	
	.add-update-preview .el-date-editor /deep/ .el-input__inner {
	  	  border: 1px solid #ddd;
	  	  border-radius: 0px;
	  	  padding: 0 10px 0 30px;
	  	  box-shadow: 0 0 0px rgba(64, 158, 255, .5);
	  	  outline: none;
	  	  color: inherit;
	  	  background: #fff;
	  	  width: auto;
	  	  font-size: 14px;
	  	  height: 36px;
	  	}
	
	.add-update-preview /deep/ .el-upload--picture-card {
		background: transparent;
		border: 0;
		border-radius: 0;
		width: auto;
		height: auto;
		line-height: initial;
		vertical-align: middle;
	}
	
	.add-update-preview /deep/ .upload .upload-img {
	  	  border: 1px solid #ddd;
	  	  cursor: pointer;
	  	  border-radius: 0px;
	  	  color: inherit;
	  	  background: #fff;
	  	  object-fit: cover;
	  	  width: 180px;
	  	  font-size: 32px;
	  	  line-height: 90px;
	  	  text-align: center;
	  	  height: 90px;
	  	}
	
	.add-update-preview /deep/ .el-upload-list .el-upload-list__item {
	  	  border: 1px solid #ddd;
	  	  cursor: pointer;
	  	  border-radius: 0px;
	  	  color: inherit;
	  	  background: #fff;
	  	  object-fit: cover;
	  	  width: 180px;
	  	  font-size: 32px;
	  	  line-height: 90px;
	  	  text-align: center;
	  	  height: 90px;
	  	}
	
	.add-update-preview /deep/ .el-upload .el-icon-plus {
	  	  border: 1px solid #ddd;
	  	  cursor: pointer;
	  	  border-radius: 0px;
	  	  color: inherit;
	  	  background: #fff;
	  	  object-fit: cover;
	  	  width: 180px;
	  	  font-size: 32px;
	  	  line-height: 90px;
	  	  text-align: center;
	  	  height: 90px;
	  	}
	
	.add-update-preview .el-textarea /deep/ .el-textarea__inner {
	  	  border: 1px solid #ddd;
	  	  border-radius: 0px;
	  	  padding: 12px;
	  	  box-shadow: 0 0 0px rgba(64, 158, 255, .5);
	  	  outline: none;
	  	  color: inherit;
	  	  background: #fff;
	  	  width: 500px;
	  	  font-size: 14px;
	  	  height: 140px;
	  	}
	
	.add-update-preview .btn .btn1 {
				border: 0px solid rgba(126, 96, 16, .2);
				cursor: pointer;
				padding: 0 20px;
				margin: 0px 4px;
				color: #666;
				display: inline-block;
				font-size: 16px;
				line-height: 24px;
				border-radius: 0px;
				outline: none;
				background: #cef7d2;
				width: auto;
				height: 40px;
			}
	
	.add-update-preview .btn .btn1:hover {
				opacity: 0.8;
			}
	
	.add-update-preview .btn .btn2 {
				border: 0px solid rgba(126, 96, 16, .2);
				cursor: pointer;
				border-radius: 0px;
				padding: 0 20px;
				margin: 0px 4px;
				outline: none;
				color: #666;
				background: #cef6f6;
				width: auto;
				font-size: 16px;
				line-height: 24px;
				height: 40px;
			}
	
	.add-update-preview .btn .btn2:hover {
				opacity: 0.8;
			}
	
	.add-update-preview .btn .btn3 {
				border: 0px solid rgba(126, 96, 16, .2);
				cursor: pointer;
				border-radius: 0px;
				padding: 0 20px;
				margin: 0px 4px;
				outline: none;
				color: #666;
				background: #cee1f6;
				width: auto;
				font-size: 16px;
				line-height: 24px;
				height: 40px;
			}
	
	.add-update-preview .btn .btn3:hover {
				opacity: 0.8;
			}
	
	.add-update-preview .btn .btn4 {
				border: 0px solid rgba(126, 96, 16, .2);
				cursor: pointer;
				border-radius: 0px;
				padding: 0 20px;
				margin: 0px 4px;
				outline: none;
				color: #666;
				background: #f7ceda;
				width: auto;
				font-size: 16px;
				line-height: 24px;
				height: 40px;
			}
	
	.add-update-preview .btn .btn4:hover {
				opacity: 0.8;
			}
	
	.add-update-preview .btn .btn5 {
				border: 0px solid rgba(126, 96, 16, .2);
				cursor: pointer;
				border-radius: 0px;
				padding: 0 20px;
				margin: 4px;
				outline: none;
				color: #666;
				background: #f7f1ce;
				width: auto;
				font-size: 16px;
				line-height: 24px;
				height: 40px;
			}
	
	.add-update-preview .btn .btn5:hover {
				opacity: 0.8;
			}
</style>
