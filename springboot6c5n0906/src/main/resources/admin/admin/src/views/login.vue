<template>
  <div>
    <div class="container" :style='{"minHeight":"100vh","alignItems":"center","background":"url(http://codegen.caihongy.cn/20240426/9c812d8e9f0b4bedb47533384fc4f946.jpg)","display":"flex","width":"100%","backgroundSize":"100% 100%","backgroundPosition":"center center","backgroundRepeat":"no-repeat","justifyContent":"center"}'>
      <el-form :style='{"border":"1px solid #f6f6f6","padding":"50px 20px","boxShadow":"0 20px 20px rgba(0, 0, 0, .1)","margin":"0 auto","borderRadius":"20px","textAlign":"center","background":"rgba(255,255,255,1)","width":"550px","fontSize":"14px","height":"auto"}'>
        <div v-if="true" :style='{"padding":"0px","margin":"0px auto 30px","borderColor":"#ddd","color":"rgba(93, 213, 200, 1)","textAlign":"center","display":"inline-block","background":"none","borderWidth":"0px","width":"100%","lineHeight":"40px","fontSize":"22px","borderStyle":"solid","fontWeight":"600"}' class="title-container">基于spring boot的快递分拣管理系统登录</div>
        <div v-if="loginType==1" class="list-item" :style='{"width":"60%","margin":"0 auto 20px","position":"relative","alignItems":"center","flexWrap":"wrap","display":"flex"}'>
          <div v-if="true" class="lable" :style='{"color":"#666","left":"-150px","textAlign":"right","width":"150px","lineHeight":"44px","fontSize":"inherit","position":"absolute"}'>用户名：</div>
          <input :style='{"border":"1px solid #eee","padding":"0 10px","boxShadow":"0 0 0px rgba(64, 158, 255, .3)","outline":"0px solid #eee","color":"#666","outlineOffset":"0px","borderRadius":"0px","background":"#fff","width":"280px","fontSize":"inherit","height":"40px"}' placeholder="请输入用户名" name="username" type="text" v-model="rulesForm.username">
        </div>
        <div v-if="loginType==1" class="list-item" :style='{"width":"60%","margin":"0 auto 20px","position":"relative","alignItems":"center","flexWrap":"wrap","display":"flex"}'>
          <div v-if="true" class="lable" :style='{"color":"#666","left":"-150px","textAlign":"right","width":"150px","lineHeight":"44px","fontSize":"inherit","position":"absolute"}'>密码：</div>
          <input :style='{"border":"1px solid #eee","padding":"0 10px","boxShadow":"0 0 0px rgba(64, 158, 255, .3)","outline":"0px solid #eee","color":"#666","outlineOffset":"0px","borderRadius":"0px","background":"#fff","width":"280px","fontSize":"inherit","height":"40px"}' placeholder="请输入密码" name="password" type="password" v-model="rulesForm.password">
        </div>

		<div class="list-item select" :style='{"width":"60%","margin":"0 auto 20px","position":"relative","alignItems":"center","flexWrap":"wrap","display":"flex"}' v-if="roles.length>1">
			<div v-if="true" class="lable" :style='{"color":"#666","left":"-150px","textAlign":"right","width":"150px","lineHeight":"44px","fontSize":"inherit","position":"absolute"}'>角色：</div>
		  <el-select v-model="rulesForm.role" placeholder="请选择角色">
		    <el-option v-if="loginType==1||(loginType==2&&item.roleName!='管理员')" v-for="item in roles" :key="item.roleName" :label="item.roleName" :value="item.roleName" />
		  </el-select>
		</div>

		
        <div :style='{"margin":"40px auto 0","alignItems":"center","flexWrap":"wrap","display":"flex","width":"60%","fontSize":"16px","position":"relative","justifyContent":"center"}'>
          <el-button v-if="loginType==1" :style='{"border":"0","cursor":"pointer","padding":"0px","margin":"0 auto 20px","color":"#fff","borderRadius":"0px","textAlign":"center","background":"#5dd5c8","width":"280px","fontSize":"16px","height":"40px"}' type="primary" @click="login()" class="loginInBt">登录</el-button>
          <el-button :style='{"border":"0px solid rgba(64, 158, 255, 1)","cursor":"pointer","padding":"0 8px","margin":"0 5px 5px","borderColor":"rgba(167,142,68,1)","color":"#5dd5c8","borderRadius":"0px","background":"none","borderWidth":"0px","width":"auto","fontSize":"inherit","borderStyle":"solid","fontWeight":"500","height":"auto"}' type="primary" @click="register('yonghu')" class="register">注册用户</el-button>
        </div>
      </el-form>

    </div>
  </div>
</template>
<script>
import menu from "@/utils/menu";
export default {
  data() {
    return {
		verifyCheck2: false,
		flag: false,
      baseUrl:this.$base.url,
      loginType: 1,
      rulesForm: {
        username: "",
        password: "",
        role: "",
      },
      menus: [],
      roles: [],
      tableName: "",
    };
  },
  mounted() {
    let menus = menu.list();
    this.menus = menus;

    for (let i = 0; i < this.menus.length; i++) {
      if (this.menus[i].hasBackLogin=='是') {
        this.roles.push(this.menus[i])
      }
    }

  },
  created() {

  },
  destroyed() {
	    },
  components: {
  },
  methods: {

    //注册
    register(tableName){
		this.$storage.set("loginTable", tableName);
		this.$router.push({path:'/register',query:{pageFlag:'register'}})
    },
    // 登陆
    login() {

		if (!this.rulesForm.username) {
			this.$message.error("请输入用户名");
			return;
		}
		if (!this.rulesForm.password) {
			this.$message.error("请输入密码");
			return;
		}
		if(this.roles.length>1) {
			if (!this.rulesForm.role) {
				this.$message.error("请选择角色");
				return;
			}

			let menus = this.menus;
			for (let i = 0; i < menus.length; i++) {
				if (menus[i].roleName == this.rulesForm.role) {
					this.tableName = menus[i].tableName;
				}
			}
		} else {
			this.tableName = this.roles[0].tableName;
			this.rulesForm.role = this.roles[0].roleName;
		}
		
		this.loginPost()
    },
	loginPost() {
		this.$http({
			url: `${this.tableName}/login?username=${this.rulesForm.username}&password=${this.rulesForm.password}`,
			method: "post"
		}).then(({ data }) => {
			if (data && data.code === 0) {
				this.$storage.set("Token", data.token);
				this.$storage.set("role", this.rulesForm.role);
				this.$storage.set("sessionTable", this.tableName);
				this.$storage.set("adminName", this.rulesForm.username);
				this.$router.replace({ path: "/" });
			} else {
				this.$message.error(data.msg);
			}
		});
	},
  }
}
</script>

<style lang="scss" scoped>
.container {
  min-height: 100vh;
  position: relative;
  background-repeat: no-repeat;
  background-position: center center;
  background-size: cover;
      background: url(http://codegen.caihongy.cn/20240426/9c812d8e9f0b4bedb47533384fc4f946.jpg);
        
  .list-item /deep/ .el-input .el-input__inner {
		border: 1px solid #eee;
		border-radius: 0px;
		padding: 0 10px;
		box-shadow: 0 0 0px rgba(64, 158, 255, .3);
		outline: 0px solid #eee;
		color: #666;
		background: #fff;
		width: 280px;
		font-size: inherit;
		outline-offset: 0px;
		height: 40px;
	  }
  
  .list-item.select /deep/ .el-select .el-input__inner {
		border: 1px solid #eee;
		border-radius: 0px;
		padding: 0 10px;
		color: #666;
		width: 276px;
		font-size: 14px;
		height: 40px;
	  }
  
  .list-code /deep/ .el-input .el-input__inner {
  	  	border: 1px solid #eee;
  	  	border-radius: 0px 0 0 0px;
  	  	padding: 0 10px;
  	  	outline: none;
  	  	color: #666;
  	  	background: none;
  	  	width: calc(100% - 80px);
  	  	font-size: inherit;
  	  	height: 40px;
  	  }

  .list-type /deep/ .el-radio__input .el-radio__inner {
		background: rgba(53, 53, 53, 0);
		border-color: #666666;
	  }
  .list-type /deep/ .el-radio__input.is-checked .el-radio__inner {
        background: rgba(167,142,68,.2);
        border-color: rgba(167,142,68,.2);
      }
  .list-type /deep/ .el-radio__label {
		color: #666666;
		font-size: 16px;
	  }
  .list-type /deep/ .el-radio__input.is-checked+.el-radio__label {
        color: rgba(50,50,50,1);
        font-size: 16px;
      }
}

</style>
