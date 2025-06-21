<template>
	<div class="navbar">
		<div class="title" :style='{"margin":"0 auto","textAlign":"center","left":"25%","background":"none","display":"block","width":"50%","position":"absolute","order":"1"}'>
			<el-image v-if="false" class="title-img" :style='{"width":"44px","objectFit":"cover","borderRadius":"100%","float":"left","height":"44px"}' src="http://codegen.caihongy.cn/20201114/7856ba26477849ea828f481fa2773a95.jpg" fit="cover" />
			<span class="title-name" :style='{"padding":"0 0 0 12px","lineHeight":"44px","fontSize":"20px","color":"#333","fontWeight":"600"}'>{{this.$project.projectName}}</span>
		</div>
		<!--
		<div class="right" :style='{"position":"absolute","right":"20px","top":"8px","display":"flex"}'>
			<div :style='{"cursor":"pointer","margin":"0 5px","lineHeight":"44px","color":"#333"}' class="nickname">{{this.$storage.get('role')}} {{this.$storage.get('adminName')}}</div>
			<div :style='{"cursor":"pointer","margin":"0 5px","lineHeight":"44px","color":"#666"}' class="logout" @click="onLogout">退出登录</div>
		</div>
		-->
		
		<el-dropdown @command="handleCommand" trigger="click" :style='{"padding":"0px","fontSize":"inherit","color":"inherit","background":"none","display":"inline-block","order":"10"}'>
		  <div class="el-dropdown-link" :style='{"width":"120px","overflow":"hidden","alignItems":"center","display":"none"}'>
		    <el-image v-if="user" :style='{"width":"42px","margin":"0 10px","objectFit":"cover","borderRadius":"8px","display":"inline-block","height":"42px"}' :src="avatar?this.$base.url + avatar : require('@/assets/img/avator.png')" fit="cover"></el-image>
		    <span :style='{"color":"inherit","lineHeight":"32px","fontSize":"14px"}'>{{this.$storage.get('adminName')}}</span>
		    <span class="icon iconfont icon-xiala" :style='{"margin":"0 0 0 5px","fontSize":"14px","color":"inherit","display":"none"}'></span>
		  </div>
		  <div class="top-el-dropdown-menu-2" :style='{"fontSize":"16px","alignItems":"center","color":"#555","justifyContent":"center","display":"flex"}'>
		    <div class="item1" @click="handleCommand('')">主页</div>
		    <div class="item2" @click="handleCommand('center')">用户信息</div>
		    <div class="item4" @click="handleCommand('logout')">退出系统</div>
		  </div>
		</el-dropdown>
	</div>
</template>

<script>
	import axios from 'axios'
	export default {
		data() {
			return {
				dialogVisible: false,
				ruleForm: {},
				user: null,
			};
		},
		created() {
		},
		computed: {
			avatar(){
				return this.$storage.get('headportrait')?this.$storage.get('headportrait'):''
			},
		},
		mounted() {
			let sessionTable = this.$storage.get("sessionTable")
			this.$http({
				url: sessionTable + '/session',
				method: "get"
			}).then(({
				data
			}) => {
				if (data && data.code === 0) {
					if(sessionTable == 'yonghu') {
						this.$storage.set('headportrait',data.data.touxiang)
					}
					if(sessionTable == 'users') {
						this.$storage.set('headportrait',data.data.image)
					}
					this.$storage.set('userForm',JSON.stringify(data.data))
					this.user = data.data;
					this.$storage.set('userid',data.data.id);
				} else {
					let message = this.$message
					message.error(data.msg);
				}
			});
		},
		methods: {
			handleCommand(name) {
				if (name == 'front') {
					this.onIndexTap()
				} else if (name == 'logout') {
					this.onLogout()
				} else if (name == 'board'){
					this.toBoard()
				} else if (name == 'backUp'){
					this.backUp()
				} 
				else {
					let router = this.$router
					name = '/'+name
					router.push(name)
				}
			},
			onLogout() {
				let storage = this.$storage
				let router = this.$router
				storage.clear()
				this.$store.dispatch('tagsView/delAllViews')
				router.replace({
					name: "login"
				});
			},
			onIndexTap(){
				window.location.href = `${this.$base.indexUrl}`
			},
		}
	};
</script>


<style lang="scss" scoped>
	.top-el-dropdown-menu-2 div.item1 {
				cursor: pointer;
				padding: 0 10px;
				color: inherit;
				display: none;
				font-size: inherit;
				line-height: 32px;
			}

	.top-el-dropdown-menu-2 div.item1:hover {
				color: #0cb8ff;
			}
	
	.top-el-dropdown-menu-2 div.item2 {
				cursor: pointer;
				padding: 0 10px;
				color: inherit;
				display: none;
				font-size: inherit;
				line-height: 32px;
			}
	
	.top-el-dropdown-menu-2 div.item2:hover {
				color: #36ab80;
			}
	
	.top-el-dropdown-menu-2 div.item3 {
				cursor: pointer;
				padding: 0 10px 0 30px;
				color: inherit;
				background: url(http://codegen.caihongy.cn/20230824/28c5329088dd4c4280b002a2af3e8bb7.png) no-repeat left center / 24px;
				font-size: inherit;
				line-height: 32px;
			}
	
	.top-el-dropdown-menu-2 div.item3:hover {
				color: #36ab80;
			}
	
	.top-el-dropdown-menu-2 div.item4 {
				cursor: pointer;
				padding: 0 10px 0 30px;
				color: inherit;
				background: url(http://codegen.caihongy.cn/20230824/99705d5c0836403ba40192a26974d34f.png) no-repeat left center / 20px;
				font-size: inherit;
				line-height: 32px;
			}
	
	.top-el-dropdown-menu-2 div.item4:hover {
				color: #36ab80;
			}
	.top-el-dropdown-menu-2 div.item5 {
				cursor: pointer;
				padding: 0 10px 0 30px;
				margin: 0 10px 0 0;
				color: inherit;
				background: url(http://codegen.caihongy.cn/20240410/d8f3dbd7c81e48789537813104594ff9.png) no-repeat left center / 24px;
				font-size: inherit;
				line-height: 32px;
			}
	
	.top-el-dropdown-menu-2 div.item5:hover {
				color: #36ab80;
			}
	.top-el-dropdown-menu-2 div.item6 {
				cursor: pointer;
				padding: 0 10px 0 30px;
				margin: 0 10px 0 0;
				color: inherit;
				background: url(http://codegen.caihongy.cn/20240410/a97b15594ac44162897660c43a549ea3.png) no-repeat left center / 24px;
				font-size: inherit;
				line-height: 32px;
			}
	
	.top-el-dropdown-menu-2 div.item6:hover {
				color: #36ab80;
			}
</style>
