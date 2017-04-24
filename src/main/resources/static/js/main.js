/**
 * Created by citizenzer0 on 12/4/16.
 */
$(document).ready(function(){
    alert('ready!');
    //$('.regist').visibility(false);
    $('.lnk_edit').click(function (e) {
        e.preventDefault();
        var name = $("#name").val();
        var age = $("#age").val();
        var diagnosis = $("#diagnosis").val();
        var id = $('.lnk_edit').attr('id');
        window.location.replace("/update?id=" + id + "&name=" + name + "&age=" + age + "&diagnosis=" + diagnosis);
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