/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function () {
  
    loadAddress();// method(see below)

    $('#add-button').on('click', function (e) {//binding picks action for event to execute

        e.preventDefault();// prevent default action of the events
        //bounding takes palce to success & error
        $.ajax({// 1 place parameters
            type: 'POST', //Matches Request Mapping on controller(POST is a property of the object)
            url: 'address', ///Links to the home controller
            data: JSON.stringify({///linked to Request body of controller
                //JSON.stringify turns everything into a string...objects -> string
                firstName: $('#add-first-name').val(),
                lastName: $('#add-last-name').val(),
                numberAndStreet: $('#add-number-and-street').val(),
                city: $('#add-city').val(),
                state: $('#add-state').val(),
                zip: $('#add-zip').val()
            }),
            headers: {//Http headers
                //accept-optional
                'Accept': 'application/json', //for Spring parses object into a Java object--what I want back
                //NEEDED
                'Content-Type': 'application/json'// sends to the server -  VERY IMPORTANT
            },
            ///optional, but recommended to be defined
            dataType: 'json'// can be defined anywhere within the .ajax ()-- 'jQuery accept/content type'

        }).success(function (data, status) { //where the event is bound
            //GETTERS
            $('#add-first-name').val('');
            $('#add-last-name').val('');
            $('#add-number-and-street').val('');
            $('#add-city').val('');
            $('#add-state').val('');
            $('#add-zip').val('');

            $('#validationErrors').empty(); //- clears out the form/flush

            loadAddress();

        }).error(function (data, status) {//data = jsp package, status = number& bound to error
            var errors = data.responseJSON.fieldErrors;//restValidationHandler
            $.each(errors, function (index, validationError) {
                var errorDiv = $('#validationErrors ');
                errorDiv.append(validationError.message)///html pg/jsp -- diplays to the user
                        .append($('<br>'));
            });
        });
    });
});

function fillAddressTable(addressList, status)
{
    clearAddressTable();//method
    var aTable = $('#contentRows');///home.jsp ---</tbody>
    $.each(addressList, function (index, address)//donkeylobser
    {
        aTable.append($('<tr>')
                .append($('<td>').append($('<a>')
                        .attr({
                            //we create variable 'contact-id'
                            'data-address-id': address.id, //element.data('contact-id', must match in html<h3>);
                            //data- -(toggele/target)...are requirement of bootstrap/jquery
                            'data-toggle': 'modal',
                            'data-target': '#detailsModal'
                        })
                        .text(address.firstName + ' ' + address.lastName)))///turns to hyperlink/contact name(s) and triggers the modal
                .append($('<td>').text(address.numberAndStreet))//append is html not written in the jsp, its direcctly written here/(Ajax)
                .append($('<td>').text(address.state))
                .append($('<td>').append(///sandwich/ending appends
                        $('<a>')
                        .attr({
                            'data-address-id': address.id, //element.data('contact-id', must match in html<h3>);
                            'data-toggle': 'modal',
                            'data-target': '#editModal'
                        })
                        .text('Edit')
                        ))
                .append($('<td>')
                        .append($('<a>')
                                .attr({'onClick': 'deleteAddress(' + address.id + ')'})
                                .text('Delete')))
                );
    });
}

function loadAddress() {

    $.ajax({
        url: "addressbook"//see home controller(Ajax)
    }).success(function (data, status) {
        fillAddressTable(data, status);//called function/method(fill__Table)
    });
}

function clearAddressTable()
{
    $('#contentRows').empty(); ///home.jsp ---</tbody>
}

$('#detailsModal').on('show.bs.modal', function (event) {//bs.modal=bootstrap->click button/show
    //event is part of bootstrap
    var element = $(event.relatedTarget);

    var addressId = element.data('address-id');///match dto ex 'id' not addressId

    var modal = $(this);

    $.ajax({
        type: 'GET',
        url: 'address/' + addressId

    }).success(function (address) {//(contact) ===donkeylobster/monkeyfish
        modal.find('#address-id').text(address.id);//( in the ().DTO)
        modal.find('#address-first-name').text(address.firstName);
        modal.find('#address-last-name').text(address.lastName);
        modal.find('#address-number-and-street').text(address.numberAndStreet);
        modal.find('#address-city').text(address.city);
        modal.find('#address-state').text(address.state);
        modal.find('#address-zip').text(address.zip);
    });
});

//EDIT EDIT EDIT EDIT EDIT EDIT EDIT EDIT EDIT EDIT EDIT EDIT EDIT EDIT EDIT
$('#editModal').on('show.bs.modal', function (event) {

    var element = $(event.relatedTarget);

    var addressId = element.data('address-id');//

    var modal = $(this);
   
    $.ajax({
        type: 'GET',
        url: 'address/' + addressId
   
    }).success(function (address) {//contact can be any variable does not have to match DTO -->>donkeylobster

        modal.find('#address-id').text(address.id);//contactId is label==text
        //INPUTS ==.val & <labels>==.text(see <h3> element on home.jsp)

        modal.find('#edit-address-id').val(address.id);
        modal.find('#edit-first-name').val(address.firstName);
        modal.find('#edit-last-name').val(address.lastName);
        modal.find('#edit-number-and-street').val(address.numberAndStreet);
        modal.find('#edit-city').val(address.city);
        modal.find('#edit-state').val(address.state);
        modal.find('#edit-zip').val(address.zip);
    });

});

$('#edit-button').click(function (event) {

    event.preventDefault();

    $.ajax({
        type: 'PUT',
        url: 'address/' + $('#edit-address-id').val(),
        data: JSON.stringify(
                {
                    id: $('#edit-address-id').val(),
                    firstName: $('#edit-first-name').val(),
                    lastName: $('#edit-last-name').val(),
                    numberAndStreet: $('#edit-number-and-street').val(),
                    city: $('#edit-city').val(),
                    state: $('#edit-state').val(),
                    zip: $('#edit-zip').val
                }),
        headers: {//Server
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        'dataType': 'json'//removed slash: data-Type
    }).success(function () {
        loadAddress();
    });
});

function deleteAddress(id)
{
    var answer = confirm("Do you really want to delete this address?");//client side verification
    if (answer === true)
    {
        $.ajax({
            type: 'DELETE',
            url: 'address/' + id//url = url path('address/') + parameter of function/method (id)

        }).success(function () {
            loadAddress();
        });
    }

}
$('#search-button').click(function (event) {

    event.preventDefault();

    $.ajax({
        type: 'POST',
        url: 'addressbook',
        data: JSON.stringify({//objects - variables seperated by commas
            firstName: $('#search-first-name').val(),
            lastName: $('#search-last-name').val(),
            numberAndStreet: $('#search-number-and-street').val(),
            city: $('#search-city').val(),
            state: $('#search-state').val(),
            zip: $('#search-zip').val()
        }),
        headers: {//commands inside of funtion - use ;
            'Accept': 'application/json',
            'Content-Type': 'application/json'

        },
        'dataType': 'json'
    }).success(function (data, status) {

        $('#search-first-name').val('');
        $('#search-last-name').val('');
        $('#search-number-and-street').val('');
        $('#search-city').val('');
        $('#search-state').val('');
        $('#search-zip').val('');

        fillAddressTable(data, status);

    });

});
