/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function(){
    loadContacts();
    
    
    
    $('#add-button').on('click', function(e) {
      
        e.preventDefault();
        
        $.ajax( {
           type: 'POST',
           url: 'contact',
           data: JSON.stringify({
                   firstName : $('#add-first-name').val(),
                   lastName : $('#add-last-name').val(),
                   company: $('#add-company').val(),
                   phone: $('#add-phone').val(),
                   email: $('#add-email').val()
                    
            }),
            
            headers: {
                'accept': 'application/json',
                'Content-Type': 'application/json'
            },
            
            dataType: 'json'
            
        }).success(function(data, status) {
            
            $('#add-first-name').val('');
            $('#add-last-name').val('');
            $('#add-company').val('');
            $('#add-phone').val('');
            $('#add-email').val('');
            
            loadContacts();
            
        });
        
        
    }); 
    
    
    
});


function loadContacts(){
    
    clearContactTable();
    
    // remove var and see what it does
    var cTable = $('#contentRows');
    
    
    
    $.ajax({
        url: "contacts"
    }).success(function(data, status) {
       
       
       
        $.each(data, function(index, contact)
        {
            cTable.append($('<tr>')
                    .append($('<td>').append($('<a>')
                        .attr({
                            'data-contact-id': contact.contactId,
                            'data-toggle': 'modal',
                            'data-target': '#detailsModal'
                        })
                        .text(contact.firstName+ ' ' + contact.lastName)))
                    .append($('<td>').text(contact.company))
                    .append($('<td>').append(
                            $('<a>')
                            .attr({
                                'data-contact-id': contact.contactId,
                                'data-toggle': 'modal',
                                'data-target': '#editModal'
                            })
                            .text('Edit')
                            ))
                    .append($('<td>').text('Delete'))
                    );
        });    
    
    
    
    
    
    });
    
    
    
    
    

}

function clearContactTable()
{
    $('#contentRows').empty(); 
}

$('#detailsModal').on('show.bs.modal', function(event){
    
    var element = $(event.relatedTarget);
    
    var contactId = element.data('contact-id');
    
    var modal = $(this);
    modal.find('#contact-id').text(dummyDetailsContact.contactId);
    modal.find('#contact-firstName').text(dummyDetailsContact.firstName);
    modal.find('#contact-lastName').text(dummyDetailsContact.lastName);
    modal.find('#contact-company').text(dummyDetailsContact.company);
    modal.find('#contact-phone').text(dummyDetailsContact.phone);
    modal.find('#contact-email').text(dummyDetailsContact.email);
    
});

$('#editModal').on('show.bs.modal', function(event){
    
    var element = $(event.relatedTarget);
    
    var contactId = element.data('contact-id');
    
    var modal = $(this);
    modal.find('#contact-id').text(dummyEditContact.contactId);
    modal.find('#edit-first-name').val(dummyEditContact.firstName);
    modal.find('#edit-last-name').val(dummyEditContact.lastName);
    modal.find('#edit-company').val(dummyEditContact.company);
    modal.find('#edit-phone').val(dummyEditContact.phone);
    modal.find('#edit-email').val(dummyEditContact.email);
});

////  TEST DATA
//
//var testContactData = [
//    {
//        contactId: 1,
//        firstName: "Susan",
//        lastName: "Williams",
//        company: "IBM",
//        email: "swilliams@ibm.com",
//        phone: "555-1212"
//    },
//    {
//        contactId: 2,
//        firstName: "George",
//        lastName: "Smith",
//        company: "EMC",
//        email: "smith@emc.com",
//        phone: "555-1234"
//    },
//    {
//        contactId: 3,
//        firstName: "Chuck",
//        lastName: "Knobloch",
//        company: "3M",
//        email: "chuck@3m.com",
//        phone: "555-5656"
//    }
//];
//
//var dummyDetailsContact = 
//  {
//      contactId: 42,
//      firstName: "Kent",
//      lastName: "Hrbek",
//      company: "3M",
//      email: "kent@3m.com",
//      phone: "444-6789"
//  };
//  
// var dummyEditContact = 
//  {
//      contactId: 52,
//      firstName: "Kirby",
//      lastName: "Puckett",
//      company: "Sun",
//      email: "kirby@sun.com",
//      phone: "123-5599"
//  }; 