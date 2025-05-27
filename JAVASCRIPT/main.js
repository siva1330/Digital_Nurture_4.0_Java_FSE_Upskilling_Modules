// 1. JavaScript Basics & Setup
console.log("Welcome to the Community Portal");

window.addEventListener('load', () => {
    alert("Welcome to the Community Event Portal!");
});

// 2. Syntax, Data Types, and Operators
const eventName = "Summer Music Festival";
const eventDate = "2024-07-15";
let availableSeats = 100;

// Template literal for event info
const eventInfo = `${eventName} - ${eventDate} - Available Seats: ${availableSeats}`;

// 3. Conditionals, Loops, and Error Handling
class Event {
    constructor(name, date, category, location, seats) {
        this.name = name;
        this.date = new Date(date);
        this.category = category;
        this.location = location;
        this.seats = seats;
        this.availableSeats = seats;
    }

    checkAvailability() {
        if (this.date < new Date()) {
            return false;
        }
        if (this.availableSeats <= 0) {
            return false;
        }
        return true;
    }

    registerUser() {
        if (this.checkAvailability()) {
            this.availableSeats--;
            return true;
        }
        return false;
    }
}

// 4. Functions, Scope, Closures, Higher-Order Functions
function createCategoryTracker() {
    const counts = {};
    return {
        increment: function(category) {
            counts[category] = (counts[category] || 0) + 1;
            return counts[category];
        },
        getCount: function(category) {
            return counts[category] || 0;
        }
    };
}

const categoryTracker = createCategoryTracker();

// 5. Objects and Prototypes
Event.prototype.getRegistrationCount = function() {
    return this.seats - this.availableSeats;
};

// 6. Arrays and Methods
const events = [
    new Event("Summer Music Festival", "2024-07-15", "music", "Central Park", 100),
    new Event("Tech Workshop", "2024-06-20", "workshop", "Tech Hub", 30),
    new Event("Basketball Tournament", "2024-08-01", "sports", "Sports Complex", 50)
];

// 7. DOM Manipulation
function displayEvents() {
    const container = document.getElementById('eventsContainer');
    container.innerHTML = '';

    events.forEach(event => {
        if (event.checkAvailability()) {
            const card = document.createElement('div');
            card.className = 'event-card';
            card.innerHTML = `
                <h3>${event.name}</h3>
                <p>Date: ${event.date.toLocaleDateString()}</p>
                <p>Category: ${event.category}</p>
                <p>Location: ${event.location}</p>
                <p>Available Seats: ${event.availableSeats}</p>
                <button onclick="registerForEvent('${event.name}')">Register</button>
            `;
            container.appendChild(card);
        }
    });
}

// 8. Event Handling
document.getElementById('categoryFilter').addEventListener('change', function() {
    const category = this.value;
    const filteredEvents = category ? 
        events.filter(event => event.category === category) : 
        events;
    displayFilteredEvents(filteredEvents);
});

document.getElementById('searchInput').addEventListener('keydown', function(e) {
    if (e.key === 'Enter') {
        const searchTerm = this.value.toLowerCase();
        const filteredEvents = events.filter(event => 
            event.name.toLowerCase().includes(searchTerm) ||
            event.location.toLowerCase().includes(searchTerm)
        );
        displayFilteredEvents(filteredEvents);
    }
});

// 9. Async JS, Promises, Async/Await
async function fetchEvents() {
    try {
        // Simulate API call
        await new Promise(resolve => setTimeout(resolve, 1000));
        return events;
    } catch (error) {
        console.error('Error fetching events:', error);
        throw error;
    }
}

// 10. Modern JavaScript Features
const filterEventsByCategory = (category = '') => {
    return events.filter(event => !category || event.category === category);
};

const addEvent = ({ name, date, category, location, seats }) => {
    const newEvent = new Event(name, date, category, location, seats);
    events.push(newEvent);
    return newEvent;
};

// 11. Working with Forms
document.getElementById('eventRegistration').addEventListener('submit', function(e) {
    e.preventDefault();
    const name = this.elements.name.value;
    const email = this.elements.email.value;
    const eventName = this.elements.eventSelect.value;

    if (!name || !email || !eventName) {
        alert('Please fill in all fields');
        return;
    }

    const event = events.find(e => e.name === eventName);
    if (event && event.registerUser()) {
        alert('Registration successful!');
        this.reset();
        displayEvents();
    } else {
        alert('Registration failed. Event might be full or past date.');
    }
});

// 12. AJAX & Fetch API
async function registerUser(userData) {
    try {
        // Simulate API call
        await new Promise(resolve => setTimeout(resolve, 1500));
        const event = events.find(e => e.name === userData.eventName);
        if (event && event.registerUser()) {
            return { success: true };
        }
        throw new Error('Registration failed');
    } catch (error) {
        throw error;
    }
}

// 13. Debugging and Testing
function debugLog(message, data) {
    console.log(`[DEBUG] ${message}`, data);
}

// 14. jQuery and JS Frameworks
$(document).ready(function() {
    // jQuery click handler
    $('#addEventBtn').click(function() {
        $('#addEventForm').fadeIn();
    });

    // jQuery form submission
    $('#newEventForm').submit(function(e) {
        e.preventDefault();
        const formData = {
            name: $('#eventName').val(),
            date: $('#eventDate').val(),
            category: $('#eventCategory').val(),
            location: $('#eventLocation').val(),
            seats: parseInt($('#eventSeats').val())
        };

        try {
            addEvent(formData);
            $('#addEventForm').fadeOut();
            displayEvents();
            alert('Event added successfully!');
        } catch (error) {
            alert(error.message);
        }
    });
});

// Add these new functions after the existing code

function displayFilteredEvents(filteredEvents) {
    const container = document.getElementById('eventsContainer');
    container.innerHTML = '';
    
    if (filteredEvents.length === 0) {
        container.innerHTML = '<div class="no-events">No events found matching your criteria</div>';
        return;
    }

    filteredEvents.forEach(event => {
        if (event.checkAvailability()) {
            const card = document.createElement('div');
            card.className = 'event-card';
            card.innerHTML = `
                <h3>${event.name}</h3>
                <p><i class="fas fa-calendar"></i> ${event.date.toLocaleDateString()}</p>
                <p><i class="fas fa-tag"></i> ${event.category}</p>
                <p><i class="fas fa-map-marker-alt"></i> ${event.location}</p>
                <p><i class="fas fa-chair"></i> Available Seats: ${event.availableSeats}</p>
                <div class="card-actions">
                    <button onclick="openRegistrationModal('${event.name}')" class="primary-btn">
                        <i class="fas fa-user-plus"></i> Register
                    </button>
                    <button onclick="viewEventDetails('${event.name}')" class="secondary-btn">
                        <i class="fas fa-info-circle"></i> Details
                    </button>
                </div>
            `;
            container.appendChild(card);
        }
    });
}

function openRegistrationModal(eventName) {
    const modal = document.getElementById('registrationForm');
    const eventSelect = document.getElementById('eventSelect');
    
    // Clear previous options
    eventSelect.innerHTML = '';
    
    // Add the selected event
    const option = document.createElement('option');
    option.value = eventName;
    option.textContent = eventName;
    eventSelect.appendChild(option);
    
    modal.style.display = 'block';
}

function closeModal() {
    document.getElementById('registrationForm').style.display = 'none';
    document.getElementById('eventRegistration').reset();
}

function closeAddEventModal() {
    document.getElementById('addEventForm').style.display = 'none';
    document.getElementById('newEventForm').reset();
}

function viewEventDetails(eventName) {
    const event = events.find(e => e.name === eventName);
    if (!event) return;

    const modal = document.createElement('div');
    modal.className = 'modal';
    modal.innerHTML = `
        <div class="modal-content">
            <div class="modal-header">
                <h2><i class="fas fa-info-circle"></i> Event Details</h2>
                <button class="close-btn" onclick="this.parentElement.parentElement.parentElement.remove()">
                    <i class="fas fa-times"></i>
                </button>
            </div>
            <div class="event-details">
                <h3>${event.name}</h3>
                <p><i class="fas fa-calendar"></i> Date: ${event.date.toLocaleDateString()}</p>
                <p><i class="fas fa-tag"></i> Category: ${event.category}</p>
                <p><i class="fas fa-map-marker-alt"></i> Location: ${event.location}</p>
                <p><i class="fas fa-chair"></i> Total Seats: ${event.seats}</p>
                <p><i class="fas fa-users"></i> Available Seats: ${event.availableSeats}</p>
                <p><i class="fas fa-user-check"></i> Registered: ${event.getRegistrationCount()}</p>
            </div>
        </div>
    `;
    document.body.appendChild(modal);
}

function updateStats() {
    const totalRegistrations = events.reduce((sum, event) => sum + event.getRegistrationCount(), 0);
    const upcomingEvents = events.filter(event => event.date > new Date()).length;
    const availableSeats = events.reduce((sum, event) => sum + event.availableSeats, 0);

    document.getElementById('totalRegistrations').textContent = totalRegistrations;
    document.getElementById('upcomingEvents').textContent = upcomingEvents;
    document.getElementById('availableSeats').textContent = availableSeats;
}

// Enhanced initializeEvents function
async function initializeEvents() {
    try {
        showLoadingSpinner();
        const loadedEvents = await fetchEvents();
        displayEvents();
        updateStats();
        hideLoadingSpinner();
    } catch (error) {
        console.error('Error loading events:', error);
        hideLoadingSpinner();
        alert('Error loading events. Please try again later.');
    }
}

function showLoadingSpinner() {
    document.getElementById('loadingSpinner').style.display = 'flex';
}

function hideLoadingSpinner() {
    document.getElementById('loadingSpinner').style.display = 'none';
}

// Add event listeners for new features
document.getElementById('viewAllUpcoming').addEventListener('click', () => {
    const upcomingEvents = events.filter(event => event.date > new Date());
    displayFilteredEvents(upcomingEvents);
});

// Close modals when clicking outside
window.onclick = function(event) {
    if (event.target.className === 'modal') {
        event.target.style.display = 'none';
    }
}

// Initialize the application
document.addEventListener('DOMContentLoaded', () => {
    initializeEvents();
}); 