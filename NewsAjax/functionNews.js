$(document).ready(function() {
    let url = `https://gnews.io/api/v4/top-headlines?token=81f446edc3fa6474a49b96b00299c414&lang=en`;
    $.ajax({
        url: url,
        method: "GET",
        dataType: "json",

        beforeSend: function() {
            $("#loader").show();
        },
        complete: function() {
            $("#loader").hide();
        },
        success: function(response) {
            console.log(response)
            let html = "";
            let lastNews = response.articles;
            for (var i in lastNews) {
                var times = lastNews[i].publishedAt;
                times = new Date();
                let ye = new Intl.DateTimeFormat('en', { year: 'numeric' }).format(times);
                let mo = new Intl.DateTimeFormat('en', { month: 'short' }).format(times);
                let da = new Intl.DateTimeFormat('en', { day: '2-digit' }).format(times);

                html += `<div id="card-news" class="col-sm-6 col-md-3">
                <div class="card">
                <div class="card-body">
                <img class="card-img-top"  src="${lastNews[i].image}" alt="Card image cap">
                    <h3 class="card-author">${lastNews[i].title}</h3>
                    <p class="card-date">Published by <strong>${lastNews[i].source.name}</strong> in <strong>${da}-${mo}-${ye}</strong></p>
                  <p class="card-title" >${lastNews[i].description}</p>
                  
                  <a href="${lastNews[i].url}" class="btn btn-primary">Read more</a>
                  
                  </div>
              </div>
              </div>`
            }

            if (html !== "") {
                $("#row-news").html(html);
                showSuccessToast();
            } else {
                showErrorToast()
            }

        },
        error: function() {
            let internetFailure = `
                        <div style="font-size:34px; text-align:center; margin-top:40px;">Please check your internet connection and try again.
                        </div>`;

            $("#row-news").html(internetFailure);
            showNotInternet()
        }
    });

    $("#searchbtn").on("click", function(e) {
        e.preventDefault();
        let search = $(".search-bar").val();
        console.log(search)
        let url = `https://gnews.io/api/v4/search?q=${search}&token=81f446edc3fa6474a49b96b00299c414&lang=en`;

        if (search !== "") {
            $.ajax({
                url: url,
                method: "GET",
                dataType: "json",

                beforeSend: function() {
                    $("#loader").show();
                },
                complete: function() {
                    $("#loader").hide();
                },
                success: function(response) {
                    console.log(response)
                    let html = "";
                    let lastNews = response.articles;
                    for (var i in lastNews) {
                        var times = lastNews[i].publishedAt;
                        times = new Date();
                        let ye = new Intl.DateTimeFormat('en', { year: 'numeric' }).format(times);
                        let mo = new Intl.DateTimeFormat('en', { month: 'short' }).format(times);
                        let da = new Intl.DateTimeFormat('en', { day: '2-digit' }).format(times);


                        html += `<div id="card-news" class="col-sm-6 col-md-3">
                        <div class="card">
                        <div class="card-body">
                        <img class="card-img-top"  src="${lastNews[i].image}" alt="Card image cap">
                            <h3 class="card-author">${lastNews[i].title}</h3>
                            <p class="card-date">Published by <strong>${lastNews[i].source.name}</strong> in <strong>${da}-${mo}-${ye}</strong></p>
                          <p class="card-title" >${lastNews[i].description}</p>
                          
                          <a href="${lastNews[i].url}" class="btn btn-primary">Read more</a>
                          
                          </div>
                      </div>
                      </div>`
                    }

                    if (html !== "") {
                        $("#row-news").html(html);
                        showSuccessToast();
                    } else {
                        showErrorToast()
                    }
                },
                error: function() {
                    let internetFailure = `
                        <div style="font-size:34px; text-align:center; margin-top:40px;">Please check your internet connection and try again.
                        </div>`;

                    $("#row-news").html(internetFailure);
                    showNotInternet()
                }
            })

        } else {
            let missingVal = `<div style="font-size:34px; text-align:center; margin-top:40px;">Please enter any search term in the search engine</div>`;
            $("#row-news").html(missingVal);
        }


    })


});