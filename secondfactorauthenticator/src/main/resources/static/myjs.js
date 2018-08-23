$(document).ready(function(){
    $("#OTPForm").hide();
    var pollInterval = null;
    $("#generate-secret").click(function(){
        var userId = $("#userId").val();
        $.post("/totptester/"+ userId+"/generate-secret",{}, function(data, status){
                            var html_text = "<b>Secret Key :</b> " + data;
                            $("#result").html(html_text);
        });
    });

    $("#generate-barcode").click(function(){
            clearInterval(pollInterval);
            var userId = $("#userId").val();
            var html_text = "<img src='/totptester/bar-code/"+ userId +"/www.sap.com'/>";
            $("#result").html(html_text);
    });


    $("#generate-totp").click(function(){
        getOtp();
        pollInterval = setInterval(function(){
            getOtp();
        }, 1000);
    });

    function getOtp(){
        var userId = $("#userId").val();
        $.get("/totptester/totp/"+userId, function(data, status){
            var html_text = "<b>Current OTP :</b> " + data;
            $("#result").html(html_text);
        });
    }

    $("#btnValidate").click(function(){
            clearInterval(pollInterval);
            var otp = $("#otpTxt").val();
            var userId = $("#userId").val();
            $.post("/totptester/validate/"+ userId+"/"+otp,{}, function(data, status){
                    var html_text = "<b>Status :</b> " + data;
                    $("#result").html(html_text);
            });

            $("#OTPForm").hide();
    });

    $("#validate").click(function(){

          $("#OTPForm").show();
          $("#otpTxt").val("");
    });

});