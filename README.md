# Auctions app
Java Android Application + SQL (TEAM)

# Tasks
### Me (Horatiu):
  * User management service: register/ login
  * DataBase: MySQL (tables for users and user roles, articles and categories for them, checkout
### Alex:
  * Creating an interface using Android Studio
  * Checkout system
### Teodor:
  * Articles management service: add/ remove/ update/ list

# Working process (in RO)
### Horatiu
Am inceput prin a crea baza de date. Am luat schema facuta si am convertit-o in limbajul SQL.

Dupa ce am avut cu ce porni la drum, am intrat in JAVA. Trebuia sa fac User Management, asa ca am inceput. Am construit un obiect User care sa mapeze toate campurile prezente in baza de date. Mai apoi am facut o interfata UserService si implementarea acesteia. 

Prima data am realizat un schelet pentru relationarea cu baza de date: 
	-o functie de conexiune
	-blocurile try with resourses si catch

Apoi am implementat functiile de adaugare, stergere, update, get, pe rand. Pentru fiecare am facut o functie separata care construia statement-ul (interogarile care urmau sa fie executate). Nu am intampinat probleme absolut deloc. Totul a mers exact cum trebuie pentru ca aveam deja planificate taskurile.

Dupa ce am terminat si testat intrarea cu baze de date, am facut functia de LOGIN care ia ca parametrii Username si Parola, cauta user-ul al carui username coincide cu cel dat. Comparam parolele, iar in functie de rezultat stabilim daca s-a realizat Login-ul sau nu. Am gasit o functie pe internet care sa cripteze parola - MD5. Inainte sa fie bagata in baza de date, aceasta este criptata, iar cand se compara este ceva de genul (deja criptata)parolaBazaDate == md5(parolaIntrodusa), adica se compara hashurile, nu se decripteaza cum as fi crezut.

### Alex


### Teo
