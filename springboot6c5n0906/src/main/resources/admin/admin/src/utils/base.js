const base = {
    get() {
        return {
            url : "http://localhost:8080/springboot6c5n0906/",
            name: "springboot6c5n0906",
            // 退出到首页链接
            indexUrl: ''
        };
    },
    getProjectName(){
        return {
            projectName: "基于spring boot的快递分拣管理系统"
        } 
    }
}
export default base
