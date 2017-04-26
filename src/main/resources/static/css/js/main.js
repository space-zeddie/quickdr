/**
 * Created by citizenzer0 on 12/4/16.
 */


$(document).ready(function(){
    //$('.regist').visibility(false);

    var prefix = '/spring-rest-with-ajax';

    var RestGet = function() {
        $.ajax({
            type: 'GET',
            url:  prefix + '/MyData/' + Date.now(),
            dataType: 'json',
            async: true,
            success: function(result) {
                alert('At ' + result.time
                    + ': ' + result.message);
            },
            error: function(jqXHR, textStatus, errorThrown) {
                alert(jqXHR.status + ' ' + jqXHR.responseText);
            }
        });
    }

    var RestPut = function() {

        var JSONObject= {
            'time': Date.now(),
            'message': 'User PUT call !!!'
        };

        $.ajax({
            type: 'PUT',
            url:  prefix + '/MyData',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(JSONObject),
            dataType: 'json',
            async: true,
            success: function(result) {
                alert('At ' + result.time
                    + ': ' + result.message);
            },
            error: function(jqXHR, textStatus, errorThrown) {
                alert(jqXHR.status + ' ' + jqXHR.responseText);
            }
        });
    }

    var RestPost = function() {
        $.ajax({
            type: 'POST',
            url:  prefix + '/MyData',
            dataType: 'json',
            async: true,
            success: function(result) {
                alert('At ' + result.time
                    + ': ' + result.message);
            },
            error: function(jqXHR, textStatus, errorThrown) {
                alert(jqXHR.status + ' ' + jqXHR.responseText);
            }
        });
    }

    var RestDelete = function() {
        $.ajax({
            type: 'DELETE',
            url:  prefix + '/MyData/' + Date.now(),
            dataType: 'json',
            async: true,
            success: function(result) {
                alert('At ' + result.time
                    + ': ' + result.message);
            },
            error: function(jqXHR, textStatus, errorThrown) {
                alert(jqXHR.status + ' ' + jqXHR.responseText);
            }
        });
    }

    $('.lnk_edit').click(function (e) {
        e.preventDefault();
        var name = $("#name").val();
        var credits = $("#credits").val();
        var prof = $("#prof").val();
        var annotation = $("#annotation").val();
        var id = $('.lnk_edit').attr('id');
        if (prof == 'null' || annotation == 'null' || !prof | !annotation)
            window.location.replace("/update?id=" + id + "&name=" + name + "&credits=" + credits);
        else window.location.replace("/update-full?id=" + id + "&name=" + name +
                "&credits=" + credits + "&prof=" + prof + "&annot=" + annotation);

    })
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