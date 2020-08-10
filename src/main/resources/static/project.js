const state = {
    loading: false,
    showButton: false,
};

const restUrl = "http://localhost:8080/api/projects?pageNumber=";

new Vue({
    el: "#app",
    data: {
        projects: [],
        pageNumber: 0,
        state,
    },
    created() {
        this.getProjects();
    },
    methods: {
        async getProjects() {
            try {
                setLoading();
                const users = await axios.get(restUrl + this.pageNumber);
                this.projects = users.data.content;
                this.pageNumber += 1;
                state.showButton = users.data.totalElements > this.projects.length;
            } catch (err) {
                console.log(err);
            }
            state.loading = false;
        },
        async moreProjects() {
            try {
                setLoading();
                const users = await axios.get(restUrl + this.pageNumber);
                this.projects = this.projects.concat(users.data.content);
                this.pageNumber += 1;
                state.showButton = users.data.totalElements > this.projects.length;
            } catch (err) {
                console.log(err);
            }
            state.loading = false;
        },
    }
})

function setLoading() {
    state.showButton = false;
    state.loading = true;
}
