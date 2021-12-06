$(function() {

    var numberStudent = 0;
    //Hàm nhập Thông tin Sinh viên
    $('.submit-btn').click(function() {
        var nameStudent = $("#nameStudent").val();
        var scoreToan = $('#scoreToan').val();
        var scoreLy = $('#scoreLy').val();
        var scoreHoa = $('#scoreHoa').val();
        var regex = /^\d+$/;
        var regexString = /^([^0-9]*)$/;
        //check điều kiện input thông tin sinh viên
        if (nameStudent.length == "" || !regexString.test(nameStudent)) {
            $(".p1").text("Please enter your name");
            $("#nameStudent").focus();
            return false;
        } else if (scoreToan.length == "" || scoreToan > 10 || !regex.test(scoreToan)) {
            $(".p2").text("Please enter your score");
            $("#scoreToan").focus();
            $(".p1").text("");
            return false;
        } else if (scoreLy.length == "" || scoreLy > 10 || !regex.test(scoreLy)) {
            $(".p3").text("Please enter your score");
            $("#scoreLy").focus();
            $(".p2").text("");
            return false;
        } else if (scoreHoa.length == "" || scoreHoa > 10 || !regex.test(scoreHoa)) {
            $(".p4").text("Please enter your score");
            $("#scoreHoa").focus();
            $(".p3").text("");
            return false;
        } else {
            $(".p4").text("");
            if (!confirm("Bạn muốn đăng ký thông tin sv này")) {
                return false;
            }
            alert("Bạn đăng ký thành công");
        }
        numberStudent++;
        var TagStudent = `<tr data-name="${nameStudent}" data-math="${scoreToan}" data-physical="${scoreLy}" data-chemistry="${scoreHoa}">
        <td>${numberStudent}</td>
        <td>${nameStudent}</td>
        <td>${scoreToan}</td>
        <td>${scoreLy}</td>
        <td>${scoreHoa}</td>
        <td>?</td>
        <td><button class ="btn btn-danger  btn-delete " type = "button">Delete</button></td>
        <td><button class ="btn btn-info  btn-edit" type="button">Edit</button></td>
        </tr>`;
        $('#dataList').append(TagStudent);

        nameStudent = $('#nameStudent').val('');
        scoreToan = $('#scoreToan').val('');
        scoreLy = $('#scoreLy').val('');
        scoreHoa = $('#scoreHoa').val('');

    });
    // hàm tính điểm sinh viên
    $('.cal-score').click(function() {
        $('#dataList tr').each(function() {
            console.log(this);
            var math = $(this).children().eq(2).html();
            var physical = $(this).children().eq(3).html();
            var chemistry = $(this).children().eq(4).html();
            var average = ((parseFloat(math) + parseFloat(physical) + parseFloat(chemistry)) / 3).toFixed(1)
            $(this).children().eq(5).html(average);
        })
    });
    //hàm xét điểm sinh viên giỏi
    $('.fil-score').click(function() {
            $.each($('#dataList tr'), function(indexInArray, valueOfElement) {
                var average = $(valueOfElement).children().eq(5);
                if (average.text() >= 8.0) {
                    average.parent().addClass("score-red");
                } else {
                    average.parent().removeClass("score-red");
                }
            });
        })
        //hàm xóa sinh viên
    $('#dataList').on('click', '.btn-delete', function() {
        if (confirm("Bạn có muốn xoa thông tin sv này ?")) {
            $(this).parents('tr').remove();
        }
    });
    // hàm chỉnh sửa tt sinh viên
    $('#dataList').on('click', '.btn-edit', function() {
        var nameStudent = $(this).parents('tr').attr('data-name');
        var scoreToan = $(this).parents('tr').attr('data-math');
        var scoreLy = $(this).parents('tr').attr('data-physical');
        var scoreHoa = $(this).parents('tr').attr('data-chemistry');
        console.log(nameStudent);
        $(this).parents('tr').find('td:eq(1)').html(`<input name="edit-text" value="${nameStudent}">`);
        $(this).parents('tr').find('td:eq(2)').html(`<input name="edit-math" value="${scoreToan}">`);
        $(this).parents('tr').find('td:eq(3)').html(`<input name="edit-physical" value="${scoreLy}">`);
        $(this).parents('tr').find('td:eq(4)').html(`<input name="edit-chemistry" value="${scoreHoa}">`);
        $(this).parents('tr').find('td:eq(7)').append("<button type='button' class ='btn btn-info  btn-update '>Update</button>");
        $(this).hide();

    });
    //hàm cập nhập tt sinh viên 
    $('#dataList').on('click', '.btn-update', function() {
        var nameStudent = $(this).parents('tr').find('input[name="edit-text"]').val();
        var scoreToan = $(this).parents('tr').find('input[name="edit-math"]').val();
        var scoreLy = $(this).parents('tr').find('input[name="edit-physical"]').val();
        var scoreHoa = $(this).parents('tr').find('input[name="edit-chemistry"]').val();

        $(this).parents('tr').find('td:eq(1)').text(nameStudent);
        $(this).parents('tr').find('td:eq(2)').text(scoreToan);
        $(this).parents('tr').find('td:eq(3)').text(scoreLy);
        $(this).parents('tr').find('td:eq(4)').text(scoreHoa);

        $(this).parents('tr').attr('data-name', nameStudent);
        $(this).parents('tr').attr('data-math', scoreToan);
        $(this).parents('tr').attr('data-physical', scoreLy);
        $(this).parents('tr').attr('data-chemistry', scoreHoa);

        $(this).parents('tr').find('.btn-edit').show();
        $(this).parents('tr').find('.btn-update').remove();

    });
});