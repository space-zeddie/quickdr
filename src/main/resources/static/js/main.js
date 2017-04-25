/**
 * Created by citizenzer0 on 12/4/16.
 */
$(document).ready(function(){
    //$('.regist').visibility(false);
    $(".form_datetime").datetimepicker({
        format: 'yyyy-mm-dd',
        autoclose: true,
        minView: 4
    });
    $('.lnk_edit').click(function (e) {
        e.preventDefault();
        var name = $("#name").val();
        var age = $("#age").val();
        var diagnosis = $("#diagnosis").val();
        var id = $('.lnk_edit').attr('id');
        window.location.replace("/update?id=" + id + "&name=" + name + "&age=" + age + "&diagnosis=" + diagnosis);
    });
    $('.lnk_edit_doc').click(function (e) {
        e.preventDefault();
        var name = $("#name").val();
        var office = $("#office").val();
        var whour1 = $("#whour1").val();
        var whour2 = $("#whour2").val();
        var id = $('.lnk_edit_doc').attr('id');
        window.location.replace("/update-doctor?id=" + id +
            "&name=" + name + "&office=" + office +
            "&whour1=" + whour1 +
            "&whour2=" + whour2);
    });
    $('.edit-doc').click(function (e) {
        e.preventDefault();
        var id = $('.edit-doc').attr('id');
        window.location.replace("/edit-doctor?id=" + id)
    });
    $('.edit-pat').click(function (e) {
        e.preventDefault();
        var id = $('.edit-pat').attr('id');
        window.location.replace("/edit-patient?id=" + id)
    });
    $('.regist_doc').click(function (e) {
        e.preventDefault();
        var name = $("#name").val();
        var office = $("#office").val();
        var whour1 = $("#whour1").val();
        var whour2 = $("#whour2").val();
        window.location.replace("/create-doctor" +
            "?name=" + name + "&office=" + office +
            "&whour1=" + whour1 +
            "&whour2=" + whour2);
    });
    $('.regist_patient').click(function (e) {
        e.preventDefault();
        var name = $("#name").val();
        var age = $("#age").val();
        var diagnosis = $("#diagnosis").val();
        window.location.replace("/register-patient" +
            "?name=" + name + "&age=" + age + "&diagnosis=" + diagnosis);
    });
    $('.regist').click(function (e) {
       e.preventDefault();
       var name = $("#name").val();
       var password = $("#password").val();
       var role = $("#role").val();
       if (role === "admin" || role === "doctor" || role === "patient")
           window.location.replace("/createuser?name=" + name + "&password=" + password + "&role=" + role);
       alert("Input admin, doctor, or patient as role");
    });
    $("#adds").click(function(e){
        e.preventDefault();
        var name = $("#name").val();
        var pass = $("#password").val();
        var role = $("#role").val();
       // window.location.replace("/createuser?name=" + name + "&password=" + pass + "&role=" + role);
        $("#link").attr("href", "/createuser?name=" + name + "&password=" + pass + "&role=" + role);
        //$('.regist').visibility(true);
    });
    $("#adds1").click(function(e){
        e.preventDefault();
        var name = $("#name").val();
        var credits = $("#credits").val();
        var prof = $("#prof").val();
        var annotation = $("#annotation").val();
        //window.location.replace("/create-full?name=" + name + "&credits=" + credits + "&prof=" + prof + "&annot=" + annotation);
        $("#link1").attr("href", "/create-full?name=" + name + "&credits=" + credits + "&prof=" + prof + "&annot=" + annotation);
        //$('.regist').visibility(true);
    });
    $(".updateProf").click(function (e) {
        e.preventDefault();
        var prof = prompt("Which professor?", "Input name");
        var id = $(".updateProf").attr("id");
       // $(this).attr("href", "/set-prof?id=" + id + "&prof=" + prof + "/");
        window.location.replace("/set-prof?id=" + id + "&prof=" + prof);
    })
})