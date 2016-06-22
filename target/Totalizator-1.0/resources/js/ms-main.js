/**
 * Created by SergeyD on 25.05.2015.
 */


function activeMenu(linkName) {
    $("#menu li").removeClass("active");
    $("#" + linkName).addClass("active");
    kendo.culture('ru-RU');
};
var kendoConstants = {
    columnWidth: "120px",
    pageSize: 25,
    buttonsColumnsWidth: "280px",
    dateFormat: "dd.MM.yyyy HH:mm"
};
var asu_pvh_constants = {
    extruderTemperatureDelta: 3,
    extruderSpeedDelta: 5,
}
