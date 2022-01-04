</h1><i> NumberSystems (Courtesy of COA Group Project)</h1></i>
 <h2><b>Implementations of various number systems</b></h2>

 <h3> The contributers of the project are: </h3>
    <li> Leone Odinga</li> 
    <li>Tinda Canon</li>
    <li>Ian Kasili</li>
    <li>Cynthia Moraa</li>



 
 <h3>1. The File called <em>DecimalFractionToBinary.java</em> will be converting floating point numbers to equivalent binary numbers according to the following question:<br></h3>

 <p><i>Write a program (Java or C++) to convert from decimal notation to binary notation for thirty (30) 
 randomly generated floating-point numbers with at most three decimal points e.g., 123.875. Your result
should give a list of randomly generated numbers, resulting binary notation and remarks column having
exactly or approximately (with at most five (5) decimal points) remark. Table Q1 (b) shows a sample of an 
expected results for 11.81 and 21.25 respectively.</p></i>

<table>
<thead>
<th>S/No</th>
<th>Decimal Number</th>
<th>Binary Number</th>
<th>Remarks</th>
</thead>
<tbody>
<tr>
<td>1</td>
<td>11.81</td>
<td>1011.01100</td>
<td>Approximate</td>
</tr>

<tr>
<td>2</td>
<td>21.25</td>
<td>10101.01</td>
<td>Exactly</td>
</tr>

</tbody>
</table>

 <h3>2.The File called <em>DecToBinToHex.java</em> will be automatically converting decimal numbers from 1 to 256 to equivalent binary numbers and hexadecimal numbers while displaying them on a table<br></h3>

 <p>In our project when we run the file a table in displayed with two columns displaying both the numbers in binary nad hexadecimal. 
   So we loop from 0 to 256 while generating binary and hex equivalents automatically in our function we first convert decimal to Bianry equivalent using stacks and lists if the number is zero we return the result and if number greater than zero then continue dividing by 2 while keeping track of the remainders then we use the stack push.This can be done using modulus 2.<br>
    
    <br> Say you want to convert 11 to binary you divide 11/2 to get 5 reminder 5 hence 1 then the 5 is divided by 2 again and so on and fouth. <br>

   <br> We later have a while loop that groups into blocks of 4 bits in the output for the next step to convert it to hexadecimal.
   Since we used stacks the final output list read from the most significant bit(falls at top of the stack)
   Then lastly we have a function to convert decimal to hexadecimal. Using the same method as in the decimal to binary only that in here we do modulus 16 instead of modulus 2
</p>

<h4>Example of the table</h4>
<table>
<thead>

<th>Dec Number</th>
<th>Binary Number</th>
<th>Hexadecimal</th>
</thead>
<tbody>
<tr>

<td>0</td>
<td>0000</td>
<td>0</td>
</tr>

<tr>

<td>1</td>
<td>0001</td>
<td>1</td>
</tr>

</tbody>
</table> 


 </h1><i> All contributions were done via GitHub</h1></i>



