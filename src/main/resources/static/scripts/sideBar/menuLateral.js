const openSidebar = document.getElementById("openSidebar");
const sidebar = document.getElementById("sidebar");

const toggleSidebar = () => {
    sidebar.classList.toggle("hideSidebar")
}

[openSidebar, sidebar].forEach((el) => {
    el.addEventListener("click", () => toggleSidebar());
})

document.addEventListener("click", (event) => {
    const isClickInsideSidebar = sidebar.contains(event.target);
    const isClickOnOpenButton = (event.target === openSidebar);

    if (!isClickInsideSidebar && !isClickOnOpenButton) {
        sidebar.classList.add("hideSidebar");
        sidebarFade.classList.add("hideSidebar");
    }
});
