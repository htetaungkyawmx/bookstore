$(document).ready(function () {
    var authenticatedUsername = $('#profile-dropdown-toggle').text().trim(); // Get the authenticated username
    if (authenticatedUsername !== "anonymousUser") {
        // Extract the initials from the authenticated username
        var initials = getInitials(authenticatedUsername);

        // Generate a consistent color based on the username
        var colorSeed = generateSeed(authenticatedUsername);
        var randomColor = generateColor(colorSeed);

        // Create the letter avatar using the initials and consistent color
        var profileImage = '<div id="profile-image" class="nav-link" style="width: 40px; height: 40px; background-color: ' + randomColor + '; border-radius: 50%; display: flex; justify-content: center; align-items: center; color: white; font-size: 16px; font-weight: bold; cursor: pointer;">' + initials + '</div>';

        // Replace the dropdown toggle's content with the generated profile image
        $('#profile-dropdown-toggle').html(profileImage);
    }
});

// Function to get the initials based on the number of names in the username
function getInitials(authenticatedUsername) {
    var initials;
    var usernameParts = authenticatedUsername.split(" ");

    if (usernameParts.length === 1) {
        // Only one name
        initials = usernameParts[0].charAt(0);
    } else if (usernameParts.length >= 2) {
        // More than one name
        initials = usernameParts[0].charAt(0) + usernameParts[usernameParts.length - 1].charAt(0);
    }
    return initials;
}

// Function to generate a seed based on the username
function generateSeed(username) {
    var seed = 0;
    for (var i = 0; i < username.length; i++) {
        seed += username.charCodeAt(i);
    }
    return seed;
}

// Function to generate a consistent color based on a seed value
function generateColor(seed) {
    var randomColor = '#' + (Math.abs(Math.sin(seed) * 16777215) & 0xFFFFFF).toString(16);
    return randomColor;
}
