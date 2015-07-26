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
                'Accept': 'application/json',
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


            $('#validationErrors').empty(); //flush for the div that displays errors

            loadDvd();

        }).error(function (data, status) {//data = jsp package, status = number
            var errors = data.responseJSON.fieldErrors;
            $.each(errors, function (index, validationError) {
                var errorDiv = $('#validationErrors ');
                errorDiv.append(validationError.message)
                        .append($('<br>'));
            });
        });
    });
});

function fillDvdTable(dvdList, status)// creates HTML & pulls from dto ex(.id)
{
    clearDvdTable();///Where DVD's are displayed (left side of page)
    var dvdTable = $('#contentRows');
    $.each(dvdList, function (index, dvd)//donkey lobsters
    {
        //IMPORTANT = Creation of the table
        dvdTable.append($('<tr>')
                .append($('<td>').append($('<a>')
                        .attr({
                            'data-dvd-id': dvd.id, //element.data('dvd-id' this makes HTML and shows up in the created methods as new attributes);
                            'data-toggle': 'modal',
                            'data-target': '#detailsModal'
                        })
                        .text(dvd.title)))//shows title as hyperlink
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
                                .attr({'onClick': 'deleteDvd(' + dvd.id + ')'}) //creates <a onClick = 'deleteDvd(3)/any id num' > Delete< /a>
                                .text('Delete')))
                );
    });
}

function loadDvd() {

    $.ajax({
        url: "dvds"//maksee request from server/ endpoint  on controller
    }).success(function (data, status) {//data:carries List<DVD>
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
    var id = element.data('dvd-id'); //!!!!!!!!!!!!!!!!!!! var anything or match DTO 

    var modal = $(this);
    $.ajax({
        type: 'GET',
        url: 'dvdLibrary/' + id///!!var set above, can be donkeyLobster
//commands inside of funtion - use ;
    }).success(function (dvd) {//(contact) ===donkeylobster/monkeyfish
        modal.find('#dvd-id').text(dvd.id); //( in the ().DTO)
        modal.find('#dvd-title').text(dvd.title);
        modal.find('#dvd-director').text(dvd.director);
        modal.find('#dvd-release-date').text(dvd.releaseDate);
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
    }).success(function (dvd) {//contact/dvd/ -function(donkeyLobster) can be any variable does not have to match DTO -->>donkeylobster
//commands inside of function - use ;
        modal.find('#dvd-id').text(dvd.id); //contactId is label==text
        
//INPUTS ==.val & labels==.text(see <h3> element on home.jsp)
        modal.find('#edit-dvd-id').val(dvd.id); //( in the ().DTO) ex - .text(donkeyLobster.id)// HIDDEN FILED  within HTML (ATTIBUTE) within Input element - see button by form tag
        modal.find('#edit-dvd-title').val(dvd.title);
        modal.find('#edit-dvd-director').val(dvd.director);
        modal.find('#edit-dvd-release-date').val(dvd.releaseDate);
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
        
        'dataType': 'json'//removed slash between data-Type
    
    }).success(function () {//commands inside of funtion - use ;
        
        loadDvd();//call the load dvd function(see above)
    });
});
function deleteDvd(id)//pulls from DVD table method, which pulls from DTO
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
        url: 'dvds',
        data: JSON.stringify({//objects - variables seperated by commas
            title: $('#search-title').val(),
            director: $('#search-director').val(),
            releaseDate: $('#search-release-date').val(),
            mpaa: $('#search-mpaa').val(),
            rating: $('#search-rating').val(),
            studio: $('#search-studio').val()
        }),
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        'dataType': 'json'
    }).success(function (data, status) {//commands inside of function - use ;

        $('#search-title').val('');
        $('#search-director').val('');
        $('#search-release-date').val('');
        $('#search-mpaa').val('');
        $('#search-rating').val('');
        $('#search-studio').val('');
        
    fillDvdTable(data, status);
    
});
});
