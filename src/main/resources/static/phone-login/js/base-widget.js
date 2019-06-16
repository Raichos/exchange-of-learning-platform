/*!
 * =====================================================
 * v0.0.1 - 一元购自定义基础组件
 *
 * =====================================================
 */
// function AutoScroll(obj){
//         $(obj).find("ul:first").animate({
//                 marginTop:"-2.175rem"
//         },500,function(){
//                 $(this).css({marginTop:"0px"}).find("li:first").appendTo(this);
//         });
//     }

/*$(".ad-pops").click(function(){                      //切换默认地址
    var a = $(this).parents().siblings('.ad-ctlbox').find('.ad-pop');
    $(".ad-pop").find('a').html('<i><\/i>设为默认');
    a.find('a').html('<i><\/i>默认地址');
    if(!a.hasClass('active')){
        $(".ad-pop").removeClass('active');
        a.addClass('active');
    };
  })
$(".ad-gourp-ctl-d").click(function(){               //删除默认地址阻止
    var a = $(this).parent().siblings('.ad-pop');
    var b = $(this).parents('li');
    $.confirm('确认删除?', function () {
      if(!a.hasClass('active')){
        b.remove();
      }else{
        $.alert('不能删除默认地址！');
      }
    });
  })*/
 function poplogin(){       //登录页弹出登录方式
    $(".modal-overlay").addClass("modal-overlay-visible");
    $(".pop-login").removeClass("pop-login-out");
    $(".pop-login").addClass("pop-login-in");
  }
  $(".login-p-cancel").click(function(){       //登录页弹出登录方式的关闭
    $(".modal-overlay").removeClass("modal-overlay-visible");
    $(".pop-login").removeClass("pop-login-in");
    $(".pop-login").addClass("pop-login-out");
  })

// $('.gettingyzm').click(function(){
//     var creg = /^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1}))+\d{8})$/;
//     var btn = $(this);
//     var count = 60;
//     if (!creg.test($('.l-phonenum').val())) {
//         $.alert("手机号码格式错误！");
//     }else{
//         var resend = setInterval(function(){
//             count--;
//             if (count > 0){
//                 btn.val(count+"秒后可重新获取");
//             }else {
//                 clearInterval(resend);
//                 btn.val("发送验证码").removeAttr('disabled style');
//             }
//         }, 1000);
//         btn.attr('disabled',true).css('cursor','not-allowed');
//         $.alert("验证码已发送");
//     }
//
// });

//提交表单
$('.phone-submit').click(function () {

    //利用ajax提交表单
    var formData = new FormData($('#phone-login-form')[0]);

    //判断空再提交

    $.ajax({
        url:'/phoneLogin',
        data:formData,  //提交表单
        type:'post',
        async: true,        //异步
        processData: false,  //很重要，告诉jquery不要对form进行处理
        contentType: false,  //很重要，指定为false才能形成正确的Content-Type
        success:function (obj) {
            if(obj == true) {
                $.alert('登陆成功!');

                //跳转登陆成功页面
                setTimeout(function(){
                    window.location.href = "/phoneLoginSuccess";
                },100);

            }else
                $.alert('登陆失败!');
        },
        error:function (obj) {
            $.alert('登陆失败!');
        }
    });
});


// function getUrlParam(name){
//   //构造一个含有目标参数的正则表达式对象
//   var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
//   //匹配目标参数
//   var r = window.location.search.substr(1).match(reg);
//   //返回参数值
//   if (r!=null) return unescape(r[2]);
//   return null;
// }

// function counttp(){
//   var endVal = $(".jumbo").attr("data-to");
//   var endVal2 = $(".jumbo2").attr("data-to");
//   var endVal3 = $(".jumbo3").attr("data-to");
//   var demowf = new countUp("myTargetElement", 0, endVal,0, 3);
//   var demowf2 = new countUp("myTargetElement2", 0, endVal2,0, 3);
//   var demowf3 = new countUp("myTargetElement3", 0, endVal3,0, 3);
//   demowf.start();demowf2.start();demowf3.start();
// }
//
// function memnum(){
//   var a = $(".group-mem-joined li").length;
//   if(a > 0 && a < 10){
//     $(".shadow").show();
//     $(".group-num-title span").text(parseInt(a));
//     $(".sd-top i").text(parseInt(10 - parseInt(a)));
//     $(".group-cork").html("<a class='tab-joingroup external' href='javascript:void(0);' onclick='shadowshow()'>我要参团</a>");
//   }else{
//     $(".group-num-title span").text(parseInt(a));
//     $(".shadow").hide();
//     $(".sd-top i").text(0);
//   }
// }
//
// function tchecktabid(){
//   if(getUrlParam('tabid') == 1){
//     $('.buttons-tab a').removeClass('active');
//     $('.otab01').addClass('active').click();
//   }else if(getUrlParam('tabid') == 2){
//     $('.buttons-tab a').removeClass('active');
//     $('.otab02').addClass('active').click();
//   }else if(getUrlParam('tabid') == 3){
//     $('.buttons-tab a').removeClass('active');
//     $('.otab03').addClass('active').click();
//   }
// }
/*
function checkNan(){
   var mob = true;
   var emt = true;
   var creg = /^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1}))+\d{8})$/;
   if (!creg.test($('.check-num').val())) {
        $.alert("手机号码格式错误！");
        mob = false;
   }
   $(".check-Nan").each(function(){
        if($(this).val() == ''){
          $.alert("亲，这样收不到货呦~");
          emt = false;
        }
    });
   if(mob == true && emt == true){
      $("#ar-sub").submit();
   }else{
    console.log("提交地址失败");
   }
}*/

$(".shadow").click(function(){            //点击遮罩关闭遮罩
  $(this).hide();
});
// function shadowshow(){     //点击参团弹出遮罩
//   $(".shadow").show();
// };

/*function getArrayItems(arr, num) {
    //新建一个数组,将传入的数组复制过来,用于运算,而不要直接操作传入的数组;
    var temp_array = new Array();
    for (var index in arr) {
        temp_array.push(arr[index]);
    }
    //取出的数值项,保存在此数组
    var return_array = new Array();
    for (var i = 0; i<num; i++) {
        //判断如果数组还有可以取出的元素,以防下标越界
        if (temp_array.length>0) {
            //在数组中产生一个随机索引
            var arrIndex = Math.floor(Math.random()*temp_array.length);
            //将此随机索引的对应的数组元素值复制出来
            return_array[i] = temp_array[arrIndex];
            //然后删掉此索引的数组元素,这时候temp_array变为新的数组
            temp_array.splice(arrIndex, 1);
        } else {
            //数组中数据项取完后,退出循环,比如数组本来只有10项,但要求取出20项.
            break;
        }
    }
    return return_array;
}

function getRandomArrayElements(arr, count) {
	var shuffled = arr.slice(0), i = arr.length, min = i - count, temp, index;
	while (i-- > min) {
		index = Math.floor((i + 1) * Math.random());
		temp = shuffled[index];
		shuffled[index] = shuffled[i];
		shuffled[i] = temp;
	}
	return shuffled.slice(min);
}*/