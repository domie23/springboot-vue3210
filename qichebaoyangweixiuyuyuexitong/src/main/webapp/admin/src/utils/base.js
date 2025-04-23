const base = {
    get() {
        return {
            url : "http://localhost:8080/qichebaoyangweixiuyuyuexitong/",
            name: "qichebaoyangweixiuyuyuexitong",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/qichebaoyangweixiuyuyuexitong/front/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "汽车维修保养智能预约系统"
        } 
    }
}
export default base
