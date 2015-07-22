/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function () {
    loadDvd();
    $('#add-button').on('click', function (e) {

        e.preventDefault();

        $.ajax({                        //adding
            type: 'POST',                  //t
            url: 'dvdLibrary',             //u
            data: JSON.stringify({          //d
//objects - variables seperated by commas(JSON.stringify)
               
                title: $('#add-title').val(),
                director: $('#add-director').val(),
                releaseDate: $('#add-release-date').val(),
                mpaa: $('#add-mpaa').val(),
                rating: $('#add-rating').val(),
                studio: $('#add-studio').val()
            }),
            headers: {
                'accept': 'application/json',
                'Content-Type': 'application/json'
            },
            dataType: 'json'
        }).success(function (data, status) {

            $('#add-title').val('');
            $('#add-director').val('');
            $('#add-release-date').val('');
            $('#add-mpaa').val('');
            $('#add-rating').val('');
            $('#add-studio').val('');


            $('#validationErrors').empty(); //WHY?  when to insert this ? - clears out the form

            loadDvd();

        }).error(function (data, status) {//data = jso package, status = number
            var errors = data.responseJSON.fieldErrors;
            $.each(errors, function (index, validaionError) {
                var errorDiv = $('#validaiontErrors ');
                errorDiv.append(validationError.message)
                        .append($('<br>'));
            });
        });
    });
});

function fillDvdTable(dvdList, status)
{
    clearDvdTable();
    var dvdTable = $('#contentRows');
    $.each(dvdList, function (index, dvd)
    {
        //IMPORTANT = Creation of the table
        dvdTable.append($('<tr>')
                .append($('<td>').append($('<a>')
                        .attr({
                            'data-dvd-id': dvd.id, //element.data('contact-id');
                            'data-toggle': 'modal',
                            'data-target': '#detailsModal'
                        })
                        .text(dvd.title + ' ' + dvd.releaseDate)))
                .append($('<td>').text(dvd.director))
                .append($('<td>').append(
                        $('<a>')
                        .attr({
                            'data-dvd-id': dvd.id, //element.data('contact-id');
                            'data-toggle': 'modal',
                            'data-target': '#editModal'
                        })
                        .text('Edit')
                        ))
                .append($('<td>')
                        .append($('<a>')
                                .attr({'onClick': 'deleteDvd(' + dvd.id + ')'})
                                .text('Delete')))
                );
    });
}

function loadDvd() {

    $.ajax({
        url: "dvds"
    }).success(function (data, status) {
        fillDvdTable(data, status); //called function/method
    });
}

function clearDvdTable()
{
    $('#contentRows').empty();
}

$('#detailsModal').on('show.bs.modal', function (event) {//bs.modal=bootstrap->click button/show
    //event is part of bootstrap
    var element = $(event.relatedTarget);
    var id = element.data('dvd-id'); //!!!!!!!!!!!!!!!!!!! var anything or match DTO?

    var modal = $(this);
    $.ajax({
        type: 'GET',
        url: 'dvdLibrary' + id///!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

//commands inside of funtion - use ;
    }).success(function (dvd) {//(contact) ===donkeylobster/monkeyfish
        modal.find('#dvd-id').text(dvd.id); //( in the ().DTO)
        modal.find('#dvd-title').text(dvd.title);
        modal.find('#dvd-director').text(dvd.director);
        modal.find('#dvd-releas-date').text(dvd.releaseDate);
        modal.find('#dvd-mpaa').text(dvd.mpaa);
        modal.find('#dvd-rating').text(dvd.rating);
        modal.find('#dvd-studio').text(dvd.studio);
    });
});
//EDIT EDIT EDIT EDIT EDIT EDIT EDIT EDIT EDIT EDIT EDIT EDIT EDIT EDIT EDIT
$('#editModal').on('show.bs.modal', function (event) {

    var element = $(event.relatedTarget);
    var id = element.data('dvd-id'); //

    var modal = $(this);
    $.ajax({
        type: 'GET',
        url: 'dvdLibrary/' + id
    }).success(function (dvd) {//contact can be any variable does not have to match DTO -->>donkeylobster
//commands inside of function - use ;
       // modal.find('#dvd-id').text(dvd.id); //contactId is label==text
        
//INPUTS ==.val & labels==.text(see <h3> element on home.jsp)
        modal.find('#dvd-id').text(dvd.id); //( in the ().DTO)
        modal.find('#edit-dvd-title').val(dvd.title);
        modal.find('#edit-dvd-director').val(dvd.director);
        modal.find('#edit-dvd-releas-date').val(dvd.releaseDate);
        modal.find('#edit-dvd-mpaa').val(dvd.mpaa);
        modal.find('#edit-dvd-rating').val(dvd.rating);
        modal.find('#edit-dvd-studio').val(dvd.studio);
    });
});
$('#edit-button').click(function (event) {
    
    event.preventDefault();
   
    $.ajax({
        type: 'PUT',
        url: 'dvdLibrary/' + $('#edit-dvd-id').val(),
        data: JSON.stringify(//objects - variables seperated by commas(JSON.stringify)
                {
                    id: $('#edit-dvd-id').val(),/////dvd vs. id
                    title: $('#edit-title').val(),
                    director: $('#edit-director').val(),
                    releaseDate: $('#edit-release-date').val(),
                    mpaa: $('#edit-mpaa').val(),
                    rating: $('#edit-rating').val(),
                    studio: $('#edit-studio').val()
                }),
        headers: {//Server
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        'data-Type': 'json'
    }).success(function () {//commands inside of funtion - use ;
        loadDvd();
    });
});
function deleteDvd(id)
{
    var answer = confirm("Do you really want to delete this DVD?"); //client side verification
    if (answer === true)
    {
        $.ajax({
            type: 'DELETE',
            url: 'dvdLibrary/' + id//url = url path + parameter of function/method

        }).success(function () {//commands inside of function - use ;
            loadDvd();
        });
    }

}
$('#search-button').click(function (event) {

    event.preventDefault();
    
    $.ajax({
        type: 'POST',
        url: 'search/dvds',
        data: JSON.stringify({//objects - variables seperated by commas
            title: $('#search-title').val(),
            director: $('#search-director').val(),
            releaseDate: $('#search-release-date').val(),
            mpaa: $('#search-mpaa').val(),
            rating: $('#search-rating').val(),
            studio: $('#search-studio')
        }),
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        'dataType': 'json'
    }).success(function (data, status) {//commands inside of function - use ;

        $('#search-title').val();
        $('#search-director').val();
        $('#search-release-date').val();
        $('#search-mpaa').val();
        $('#search-rating').val();
        $('#search-studio');
        fillDvdTable(data, status);
    });
});
