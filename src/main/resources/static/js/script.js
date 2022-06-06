function init(pageNum) {
    $.ajax({
        url:"/index.action",
        type:"POST",
        data:{pageNum:pageNum},
        dataType:"json",
        success:function (data) {
            $("#phone").html("");
            var tr="<tr>"
                +"<th>序号</th>"
                +"<th>标题</th>"
                +"<th>回复/查看</th>"
                +"<th>发表时间</th>"
                +"<th>最新回复</th>"
                +"</tr>";
            $.each(data.pageInfo.list,function (i,info) {
                tr=tr+"<tr>"+
                    "<td>"+info.id+"</td>"+
                    "<td><a href='detail.html?id="+info.id+"'>"+info.title+"</a></td>"+
                    "<td>"+info.replyCount+"/"+info.viewCount+"</td>"+
                    "<td>"+info.reportTime+"</td>"+
                    "<td>"+info.lastPostTime+"</td>"+
                    "</tr>"

            });
            $("#phone").append(tr);
            $("#phone tr:odd").css("background",'#ccc');
            $("#page").html("");
            $("#page").append("<a href='javascript:void(0);'onclick='init(1)'>首页</a>&ensp; "+
                "<a href='javascript:void(0);'"+"onclick='init("+(data.pageInfo.pageNum-1)+")'>上一页</a>&ensp;"+
                "<a href='javascript:void(0);'"+"onclick='init("+(data.pageInfo.pageNum+1)+")'>下一页</a>&ensp;"+
                "<a href='javascript:void(0);'"+"onclick='init("+(data.pageInfo.pages)+")'>末页</a>&ensp;"+
                "第"+data.pageInfo.pageNum+"页/共"+data.pageInfo.pages+"页"

            )
        }
    });
}

function getInformation() {
    var id=getUrlParam('id');
    $.ajax({
        url:"/detail.action",
        type:"POST",
        data:{id:id},
        dataType:"json",
        success:function (data) {
            $("#title").html(data.info.title);
            $("#reportTime").html("发表于:"+data.info.reportTime);
            $("#content1").html(data.info.content);
            $("#infoId").val(id);
            var replyContent;
            $.each(data.rlist,function (i,rp) {
                replyContent=replyContent+ "<div class='rep'>发表于："+
                    re.replyTime+"<br/>"+rp.replyTime+"<br/>"+rp.content+"</div>"
            });
            $("#reply").appendChild(replyContent);
        }
    })
    
}

function replyCountent() {
    var infoId=$("#infoId").val();
    var content=$("#content").val();
    if(content==""){
        $("#msg").html("请填写内容")
    }else if(content.length>200){
        $("#msg").html("内容不能超过200字")
    }else{
        $("#msg").html("")
        $.ajax({
            url:"/addReplies.action",
            type:"POST",
            data:{infoId:infoId,content:content},
            dataType:"json",
            success:function (data) {
                if(data.flag=="success"){
                    alert("成功");
                    $("#reply").append("<div class='rep'>发表于："
                    +data.replies.replyTime+"<br/>"+data.replies.content+"</div>")
                }
            }
        })
    }


}

function getUrlParam(name){
    var reg=new RegExp("(^|&)"+name+"=([^&*(&|$)])");
    var r=window.location.search.substr(1).match(reg);
    if(r!=null){
        return unescape(r[2]);
    }
    return null;
}