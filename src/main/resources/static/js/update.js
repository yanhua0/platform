$(function () {
    $(".edit").click(function () {
        var id = $(this).siblings(".aid").val();
        $("#editId").val(id);
    })
});
