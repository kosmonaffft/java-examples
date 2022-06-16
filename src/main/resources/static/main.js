console.log("Hello, world!!!");

function onUserDelete() {
    alert("DELETING!!!");
}

function onHover() {
    console.log("HOVERED!!!")
}

function onLastNameClick() {
    fetch('/api/users')
        .then(function (response) {
            return response.json();
        })
        .then(function (data) {
            return console.log(data);
        });
}
