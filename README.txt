Aplikacja pogodowa
Startujemy od Application.MainApp

1.Configuration 	- za pomoc� inputa mo�na wybra� miasto, gdy wpiszemy z�e, 
			  b�d� nie ma tej miejscowo�ci w bazie openWeatherMap wyskakuje nam allert,
			  a tak�e gdy nie ma po��czenia sieciowego

2.Weather		- wy�wietla nam obecne informacje pogodowe dla danej miejscowo�ci,
			  gdy miejscowo�� nie zosta�a wybrana w panelu Configuration,
			  to pobiera nam informacje pogodowe dla miejscowo�ci Warsaw

3.Weather Advanced	- wy�wietla nam pogod� dla danej miejscowo�ci,
			  w zale�no�ci jaki przysz�y dzie� wybrali�my


Aplikacja jest zabezpieczona, gdy nie ma po��czenia sieciowego wy�wietla nam ostatnie warto�ci pogodowe,
kt�re odczytuje z pliku csv.
