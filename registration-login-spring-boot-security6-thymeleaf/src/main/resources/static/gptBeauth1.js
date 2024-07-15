document.addEventListener("DOMContentLoaded", function() {
    const monthSelect = document.getElementById("month");
    const calendarBody = document.getElementById("calendar-body");

    // Функция для создания календаря для выбранного месяца
    function createCalendar(month) {
        // Очистка календаря
        calendarBody.innerHTML = "";

        // Получаем день недели первого числа выбранного месяца
        const firstDay = new Date(2024, month - 1, 1).getDay();

        // Получаем количество дней в выбранном месяце
        const daysInMonth = new Date(2024, month, 0).getDate();

        // Создаем строки для каждой недели месяца
        let row = document.createElement("tr");
        for (let i = 0; i < firstDay; i++) {
            let cell = document.createElement("td");
            row.appendChild(cell);
        }
        for (let day = 1; day <= daysInMonth; day++) {
            let cell = document.createElement("td");
            let button = document.createElement("button");
            button.textContent = day;
            button.classList.add("day-btn");
            button.dataset.day = day;
            button.dataset.month = month;
            cell.appendChild(button);
            row.appendChild(cell);
            if ((firstDay + day - 1) % 7 === 6) {
                calendarBody.appendChild(row);
                row = document.createElement("tr");
            }
        }
        // Добавляем последнюю неделю, если она неполная
        if (row.children.length > 0) {
            calendarBody.appendChild(row);
        }

        // Добавляем обработчики клика на каждую кнопку в календаре
        const buttons = document.querySelectorAll(".day-btn");
        buttons.forEach(button => {
            button.addEventListener("click", function() {
                const clickedDay = this.dataset.day;
                const clickedMonth = this.dataset.month;
                console.log("Выбран день:", clickedDay, "Месяц:", clickedMonth);
                // Здесь можно добавить логику для обработки выбранного дня
            });
        });
    }

    // Обработчик изменения выбранного месяца
    monthSelect.addEventListener("change", function() {
        const selectedMonth = parseInt(this.value);
        createCalendar(selectedMonth);
    });

    // Инициализация календаря для текущего месяца при загрузке страницы
    const currentMonth = new Date().getMonth() + 1;
    monthSelect.value = currentMonth;
    createCalendar(currentMonth);
});
