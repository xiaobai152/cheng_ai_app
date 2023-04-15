$(document).ready(function () {

    // 2 提交File异步请求
    $("#submit").bind("click", function () {

        // [0] 获取表单第一个组件
        let $form = $("#uploadForm")[0];

        // FormData 可以把表单及表单的组件进行序列化（数组、字典）
        var $formData = new FormData($form);
        // $formData.append(key,value);

        let config = {
            url: "http://localhost:8003/listen",
            method: "POST", // POST无内存限制，可以提交文件
            dataType: "JSON",
            data: $formData,
            processData: false, // 关闭数据验证
            contentType: false, // 关闭类型验证
            success: function (resp) {
                console.log(resp)
                // 动态标签更新
                if (resp.err_msg == "success.") {
                    $("#text").text(resp.result[0])
                } else {
                    alert(resp.error_msg);
                }

            },
            error: function (resp) {

            }
        }
        $.ajax(config);
    });
});

