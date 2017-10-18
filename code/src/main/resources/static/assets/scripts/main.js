
// http
(function(global,$){
	function request(url,payload){
        var tk = global.sessionStorage.getItem("tk");
		return $.ajax({
            url:url,
            method:payload.method,
            data:payload.data,
            dataType:payload.dataType || 'json',
            beforeSend: function(jqxhr){
                var headers = jqxhr.getAllResponseHeaders();
                if(tk){
                    jqxhr.setRequestHeader("tk",tk);
                }
                // open loading
            },
            // "success", "notmodified", "nocontent", "error", "timeout", "abort", or "parsererror"
            complete: function(jqxhr,textStatus){
                // close loading
            },
            success: function(data, status,jqxhr){
                // 
            },
            // "timeout", "error", "abort", and "parsererror,404,500...
            error: function(jqxhr, status){
                // 401,403 to --> login
                if(status == 401 || status == 403){
                    document.location.href = "/login.html";
                } else {
                    // show error message
                }
            }
        })
	}

	var _ajax = {
			get: function(url,params){
				return request(url,{method:'GET',data:params});
			},
			post: function(url,params){
				return request(url,{method:'POST',data:params});
			},
			put: function(url,params){
				return request(url,{method:'PUT',data:params});
			},
			del: function(url,params){
				return request(url,{method:'DELETE',data:params});
			}
	}
	global._ajax = _ajax;
}(window,jQuery,undefined));


// utils

//


// validation
(function(global,$){
    _validate = function(options){
        this.o=$.extend(true,{},this.defaults,options);
        var inputs = !!this.o.formID?$(this.o.formID).find("input[rules]"):$("input[rules]"),elems=[];
        inputs.each(function(e){
            if($(this).attr("rules")!=""){
                elems.push({"type":$(this).attr("rules"),"node":this.id,"val":this.value});
            }
        });
        this.doinit(elems);
    }
    _validate.prototype.defaults={
        rules:{
            "idcard":{
                "regex":"func",
                "errorMsg":"身份证号码有误",
                "infoMsg":""
            },
            "number":{
                "regex":/\d+/,
                "errorMsg":"请输入数字",
                "infoMsg":""
            },
            "word":{
                "regex":/\w+/,
                "errorMsg":"请输入英文字母或下划线",
                "infoMsg":""
            },
            "english":{
                "regex":/[A-Za-z_]+/,
                "errorMsg":"",
                "infoMsg":""
            },
            "chinese":{
                "regex":/[\4e00-\9fa0]+/,
                "errorMsg":"请输入中文字符",
                "infoMsg":""
            },
            "phone":{
                "regex":/^1[3|4|5|8]\d{9}$/,
                "errorMsg":"手机号码有误",
                "infoMsg":""
            },
            "areaCode":{
                "regex":/\d{3,4}/,
                "errorMsg":"区号有误",
                "infoMsg":""
            },
            "tel":{
                "regex":/\d{3,4}\d{7,8}|\d{3,4}[-\s]\d{7,8}([-\s]\d{3,6})?/,
                "errorMsg":"电话号码有误",
                "infoMsg":""
            },
            "email":{
                "regex":/^[\w.-]+@\w+(\.\w+)?\.\w{2,3}/gi,
                "errorMsg":"Email地址有误",
                "infoMsg":""
            },
            "postCode":{
                "regex":/\d{6}/,
                "errorMsg":"邮政编码有误",
                "infoMsg":""
            },
            "validCode":{
                "regex":/\d{6}/,
                "errorMsg":"验证码有误",
                "infoMsg":""
            },
            "password":{
                "regex":/((?=.*[A-Za-z~!@#$%^&*()-+=|{}<>\?])(?=.*\d)|(?=.*\d)(?=.*A-Za-z~!@#$%^&*()-+=|{}<>\?))[\w\~!@#$%\^&\*\(\)-+=|<>\?]{8,16}/,
                "errorMsg":"密码必须是8-16位英文字母和数字的组合",
                "infoMsg":""
            },
            "password2":{
                "regex":"func",
                "errorMsg":"两次输入的密码不一致",
                "infoMsg":""
            },
            "range":{
                "regex":"func",
                "errorMsg":"超出范围",
                "infoMsg":""
            },
            "min":{
                "regex":"func",
                "errorMsg":"少于最小值",
                "infoMsg":""
            },
            "max":{
                "regex":"func",
                "errorMsg":"大于最大值",
                "infoMsg":""
            },
            "leng":{
                "regex":"func",
                "errorMsg":"字符长度超出范围",
                "infoMsg":""
            },
            "nonEmpty":{
                "regex":"func",
                "errorMsg":"必填项",
                "infoMsg":""
            }
        }
    }

    _validate.prototype.blur = function(){}
    _validate.prototype.isEmpty = function(obj){}
    _validate.prototype.showMsg = function(valid,elem,msg){}
    _validate.prototype.isValid = function(){}
    _validate.prototype.isValid = function(){}
    _validate.prototype.reset = function(type,i,k){}
    _validate.prototype.doValid = function(type,elem,i,l,k){}
    _validate.prototype.validate = function(elem,k){}
    _validate.prototype.doinit = function(elems){}

    function idcard(){}
    function number(){}
    function phone(){}
    function english(){}
    function chinese(){}
    function areaCode(){}
    function tel(){}
    function email(){}
    function postCode(){}
    function validCode(){}
    function password(){}
    function password2(){}
    function range(){}
    function min(){}
    function max(){}
    function leng(){}
    function nonEmpty(){}
    function word(){}

}(window,jQuery,undefined))
