document.addEventListener("DOMContentLoaded", function() {
    const monthSelect = document.getElementById("month");
    const calendarBody = document.getElementById("calendar-body");

    // Функция для создания календаря для выбранного месяца
    function createCalendar(month) {
        // Очистка таблицы
        calendarBody.innerHTML = "";

        // Получаем количество дней в выбранном месяце
        const daysInMonth = new Date(2024, month, 0).getDate();

        // Создаем строки для каждого дня месяца
        for (let day = 1; day <= daysInMonth; day++) {
            const row = document.createElement("tr");
            row.innerHTML = `
        <td>${day}</td>
        <td>08:00 - 10:00</td>
        <td><button class="book-btn">Записаться</button></td>
      `;
            calendarBody.appendChild(row);
        }
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
