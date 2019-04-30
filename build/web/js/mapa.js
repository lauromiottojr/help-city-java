var geocoder;
var map;
var marker;
function initialize(la, lo) {
    var latlng = new google.maps.LatLng(la, lo);
    var options = {
        zoom: 15,
        center: latlng,
        mapTypeId: google.maps.MapTypeId.ROADMAP
    };
    map = new google.maps.Map(document.getElementById("mapa"), options);
    geocoder = new google.maps.Geocoder();
    marker = new google.maps.Marker({
        map: map,
        draggable: true
    });
    marker.setPosition(latlng);
}
function getLocation() {
    if (navigator.geolocation)
    {
        navigator.geolocation.getCurrentPosition(showPosition);
    } else {
        alert("Geolocalização não é suportada nesse browser.");
    }
}
function showPosition(position) {
    lat = position.coords.latitude;
    lng = position.coords.longitude;
    latlng = new google.maps.LatLng(lat, lng);
    mapa = document.getElementById('mapa');
    var myOptions = {
        center: latlng, zoom: 14,
        mapTypeId: google.maps.MapTypeId.ROADMAP,
        mapTypeControl: false,
        navigationControlOptions: {style: google.maps.NavigationControlStyle.SMALL}
    };
    map = new google.maps.Map(document.getElementById("mapa"), myOptions);
    marker = new google.maps.Marker({position: latlng, map: map, draggable: true, title: "Você está Aqui!"});
    geocoder.geocode({'latLng': marker.getPosition()}, function (results, status) {
        if (status == google.maps.GeocoderStatus.OK) {
            if (results[0]) {
                $('#txtEndereco').val(results[0].formatted_address);
                $('#txtLatitude').val(marker.getPosition().lat());
                $('#txtLongitude').val(marker.getPosition().lng());
            }
        }
    });
    google.maps.event.addListener(marker, 'drag', function () {
        geocoder.geocode({'latLng': marker.getPosition()}, function (results, status) {
            if (status == google.maps.GeocoderStatus.OK) {
                if (results[0]) {
                    $('#txtEndereco').val(results[0].formatted_address);
                    $('#txtLatitude').val(marker.getPosition().lat());
                    $('#txtLongitude').val(marker.getPosition().lng());
                }
            }
        });
    });
}
$(document).ready(function () {

    /*function carregarNoMapa(endereco) {
     geocoder.geocode({'address': endereco + ', ', 'region': ''}, function (results, status) {
     if (status == google.maps.GeocoderStatus.OK) {
     if (results[0]) {
     var latitude = results[0].geometry.location.lat();
     var longitude = results[0].geometry.location.lng();
     
     $('#txtEndereco').val(results[0].formatted_address);
     $('#txtLatitude').val(latitude);
     $('#txtLongitude').val(longitude);
     
     var location = new google.maps.LatLng(latitude, longitude);
     marker.setPosition(location);
     map.setCenter(location);
     map.setZoom(16);
     }
     }
     })
     }*/
    google.maps.event.addListener(marker, 'drag', function () {
        geocoder.geocode({'latLng': marker.getPosition()}, function (results, status) {
            if (status == google.maps.GeocoderStatus.OK) {
                if (results[0]) {
                    $('#txtEndereco').val(results[0].formatted_address);
                    $('#txtLatitude').val(marker.getPosition().lat());
                    $('#txtLongitude').val(marker.getPosition().lng());
                }
            }
        });
    });
    $("#txtEndereco").autocomplete({
        source: function (request, response) {
            geocoder.geocode({'address': request.term + ', Brasil', 'region': 'BR'}, function (results, status) {
                response($.map(results, function (item) {
                    return {
                        label: item.formatted_address,
                        value: item.formatted_address,
                        latitude: item.geometry.location.lat(),
                        longitude: item.geometry.location.lng()
                    }
                }));
            })
        },
        select: function (event, ui) {
            $("#txtLatitude").val(ui.item.latitude);
            $("#txtLongitude").val(ui.item.longitude);
            var location = new google.maps.LatLng(ui.item.latitude, ui.item.longitude);
            marker.setPosition(location);
            map.setCenter(location);
            map.setZoom(16);
        }
    });
});