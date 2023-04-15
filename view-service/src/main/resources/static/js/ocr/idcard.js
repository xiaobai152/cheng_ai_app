$(document).ready(function () {

    // 1 图片同步
    $("#file").bind("change", function () {
        // $(this)[0] 获取多文件提交的第一个文件
        // files[0] 文件属性集合
        var file = $(this)[0].files[0];
        // http://id:port/file.jpg createObjectURL 创建URL地址
        // src: path、url、base64
        $("#show_img").attr({"src": URL.createObjectURL(file)});
    });

    // 2 提交File异步请求
    $("#submit").bind("click", function () {

        // [0] 获取表单第一个组件
        let $form = $("#uploadForm")[0];

        // FormData 可以把表单及表单的组件进行序列化（数组、字典）
        var $formData = new FormData($form);
        // $formData.append(key,value);

        let config = {
            url: "http://localhost:8001/text?action=card",
            method: "POST", // POST无内存限制，可以提交文件
            dataType: "json",
            data: $formData,
            processData: false, // 关闭数据验证
            contentType: false, // 关闭类型验证
            success: function (resp) {
                // 动态标签更新
                $("#home").text(resp.words_result.住址.words);
                $("#id").text(resp.words_result.公民身份号码.words);
                $("#birth").text(resp.words_result.出生.words);
                $("#name").text(resp.words_result.姓名.words);
                $("#sex").text(resp.words_result.性别.words);
                $("#nation").text(resp.words_result.民族.words);

            },
            error: function (resp) {
                alert(resp)
            }
        }
        $.ajax(config);
    });
});

