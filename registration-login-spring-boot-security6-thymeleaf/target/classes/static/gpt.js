function toggleDropdown() {
    var dropdownContent = document.getElementById("dropdown-content");
    if (dropdownContent.style.display === "none" || dropdownContent.style.display === "") {
        dropdownContent.style.display = "block";
    } else {
        dropdownContent.style.display = "none";
    }
}
