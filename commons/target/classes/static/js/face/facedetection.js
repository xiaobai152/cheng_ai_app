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
            url: "http://localhost:8002/face?action=faceDetect",
            method: "POST", // POST无内存限制，可以提交文件
            dataType: "JSON",
            data: $formData,
            processData: false, // 关闭数据验证
            contentType: false, // 关闭类型验证
            success: function (resp) {
                console.log(resp)
                // 动态标签更新
                if (resp.error_msg == "SUCCESS") {
                    $("#num").text(resp.result.face_num);
                    let len = resp.result.face_num;
                    var face_token = "";
                    var age = "";
                    var beauty = "";
                    var sex = "";
                    var emotion = "";
                    for (var i = 0;i < len;i++){
                        face_token += " " + resp.result.face_list[i].face_token;
                        age += " " + resp.result.face_list[i].age;
                        beauty += " " + resp.result.face_list[i].beauty;
                        var s = resp.result.face_list[i].gender.type;
                        emotion += " " + resp.result.face_list[0].emotion.type;
                        if (s == "female") {
                            sex += " " + "女性";
                        } else {
                            sex += " " + "男性";
                        }
                    }
                    $("#token").text(face_token);
                    $("#age").text(age);
                    $("#beauty").text(beauty);
                    $("#sex").text(sex);
                    $("#mood").text(emotion);
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

