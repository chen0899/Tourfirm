$(document).ready(function () {
    $('#PersonTableContainer').jtable({
        title: 'Table of people',
        actions: {
            listAction: 'RoomServlet?action=list',
            createAction: 'RoomServlet?action=create',
            updateAction: 'RoomServlet?action=update',
            deleteAction: 'RoomServlet?action=delete'
        },
        fields: {
            roomId: {
                title: 'Id',
                key: true,
                list: true,
                create: true
            },
            roomNumber: {
                title: 'Number of room',
                width: '30%',
                edit: false
            },
            countPlaces: {
                title: 'Count places',
                width: '30%',
                edit: true
            },
            hotel: {
                title: 'Hotel',
                width: '20%',
                edit: true
            },
            roomType: {
                title: 'Room type',
                width: '20%',
                edit: true
            }
        }
    });
    $('#PersonTableContainer').jtable('load');
});