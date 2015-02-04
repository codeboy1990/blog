$.ajaxSetup({
    error : function(xhr, textStatus, error) {
        var err_code = xhr.status;
        switch (err_code) {
        case 404:
            alert('请求路径没有找到.');
            break;
        case 500:
            alert('服务器发生错误, 请稍后再试.');
            break;
        case 405:
            alert('权限不足');
            break;
        case 403:
            alert('请先登陆.');
            window.parent.location.reload();
            break;
        case 10001:
        	alert("用户名不能为空");
        	break;
        case 10002:
        	alert("密码不能为空");
        	break;
        case 10003:
        	alert("用户名或密码错误");
        	break;
        case 10004:
        	alert("名称不能为空");
        	break;
        case 10005:
        	alert("权限的链接不能为空");
        	break;
        case 10006:
        	alert("已存在该名称的权限");
        	break;
        case 10007:
        	alert("已存在该名称的角色");
        	break;
        case 10008:
        	alert("用户名不能为空");
        	break;
        case 10009:
        	alert("已存在该用户名的管理员");
        	break;
        case 10010:
        	alert("请分配一个角色");
        	break;
        default:
            alert('请求发生错误.');
            break;
        }
    },
    beforeSend : function(xhr) {
        if (!(document.cookie || navigator.cookieEnabled)) {
            alert('您的浏览器关闭了cookie功能, 这样可能会影响您在本站的体验.');
        }
    }
});