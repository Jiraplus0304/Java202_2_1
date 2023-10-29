<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="bg-blue-500">
<div class="bg-white mx-auto text-center w-1/2 py-5 shadow-xl rounded-3xl my-96 max-2xl">
    <h2 class="mx-6 border-b pb-2 text-4xl font-semibold">Compound Interest Calculator</h2>
    <h3 class="bg-red-300 text-red-900 font-semibold text-xl w-80 rounded-lg my-2 mx-auto">${error}</h3>
    <form action="/" method="POST">
        <div class="grid grid-cols-2 gap-4 my-5 mx-8">
            <label for="principle-amount" class="text-xl flex items-center">Principal Amount: <span
                    class="text-grey-500 mx-l">$</span></label>
            <input class="xw-full p-1 border-2 placeholder-blue-800 border-blue-700 appearance-none rounded-lg focus:outline-none focus:ring-2"
                   id="principle-amount" type="number" name="principleAmount" value="${principal}"/>

            <label for="interest" class="text-xl flex items-center">Interest Percentage:</label>
            <input class="w-full p-1 border-2 placeholder-blue-800 border-blue-700 appearance-none rounded-lg focus:outline-none focus:ring-2"
                   id="interest" type="number" min="1" max="100" name="interest" value="${interest}"/>

            <label for="years" class="text-xl flex items-center"># of Years:</label>
            <input class="w-full p-1 border-2 placeholder-blue-800 border-blue-700 appearance-none rounded-lg focus:outline-none focus:ring-2"
                   id="years" type="number" min="1" name="years" value="${years}"/>

            <label for="compoundinperiod" class="text-xl flex items-center">Times per Year:</label>
            <input class="w-full p-1 border-2 placeholder-blue-800 border-blue-700 appearance-none rounded-lg focus:outline-none focus:ring-2"
                   id="compoundinperiod" type="number" min="1" max="12" name="compoundingPeriod"
                   value="${compoundingPeriod}"/>
        </div>

        <button class="bg-blue-300 text-xl font-semibold px-4 py-1 rounded-lg hover:bg-blue-800 hover:text-white"
                type="submit">Calculate
        </button>
        <p class="text-3xl font-mono text-green-600">Result: ${result}</p>
    </form>
</div>

</body>
</html>