$(document).ready(function () {
    $("button[id|='update']").click(function () {
        var row = $(this).closest("tr");
        var name = row.data("name");
        var age = row.data("age");
        alert("name: " + name + " age:" + age);
    })
});