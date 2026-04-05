function sendMessage() {
    const input = document.getElementById("message");
    const message = input.value.trim();

    if (!message) return;

    addMessage(message, "user");
    input.value = "";

    fetch(`/api/ollama/${encodeURIComponent(message)}`)
        .then(res => res.text())
        .then(data => {
            addMessage(data, "bot");
        })
        .catch(err => {
            addMessage("Error: Could not reach server", "bot");
        });
}

function addMessage(text, type) {
    const chatBox = document.getElementById("chatBox");

    const msg = document.createElement("div");
    msg.classList.add("message", type);
    msg.innerText = text;

    chatBox.appendChild(msg);
    chatBox.scrollTop = chatBox.scrollHeight;
}

function handleKey(event) {
    if (event.key === "Enter") {
        sendMessage();
    }
}