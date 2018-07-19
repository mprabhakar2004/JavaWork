$(document).ready(function(){
    $("#OTPForm").hide();
    var pollInterval = null;
    $("#generate-secret").click(function(){

        $.get("/totptester/generate-secret", function(data, status){
                var html_text = "<b>Secrete Key :</b> " + data;
                $("#result").html(html_text);
        });
    });

    $("#generate-barcode").click(function(){

            var html_text = "<img src='/totptester/bar-code/manish@2fa.com/manish.com'/>";
            $("#result").html(html_text);
            clearInterval(pollInterval);
    });


    $("#generate-totp").click(function(){
        getOtp();
        pollInterval = setInterval(function(){
            getOtp();
        }, 1000);
    });

    function getOtp(){
        $.get("/totptester/totp", function(data, status){
            var html_text = "<b>Current OTP :</b> " + data;
            $("#result").html(html_text);
        });
    }

    $("#btnValidate").click(function(){

            var otp = $("#otpTxt").val();
            $.post("/totptester/validate/"+otp,{}, function(data, status){
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