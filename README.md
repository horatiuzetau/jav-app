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
  * Automation test

# Working process (in RO)
### Horatiu
Am inceput prin a crea baza de date. Am luat schema facuta si am convertit-o in limbajul SQL.

Dupa ce am avut cu ce porni la drum, am intrat in JAVA. Trebuia sa fac User Management, asa ca am inceput. Am construit un obiect User care sa mapeze toate campurile prezente in baza de date. Mai apoi am facut o interfata UserService si implementarea acesteia. 

Prima data am realizat un schelet pentru relationarea cu baza de date: 
	-o functie de conexiune
	-blocurile try with resourses si catch

Apoi am implementat functiile de adaugare, stergere, update, get, pe rand. Pentru fiecare am facut o functie separata care construia statement-ul (interogarile care urmau sa fie executate). Nu am intampinat probleme absolut deloc. Totul a mers exact cum trebuie pentru ca aveam deja planificate taskurile.

Dupa ce am terminat si testat intrarea cu baze de date, am facut functia de LOGIN care ia ca parametrii Username si Parola, cauta user-ul al carui username coincide cu cel dat. Comparam parolele, iar in functie de rezultat stabilim daca s-a realizat Login-ul sau nu. Am gasit o functie pe internet care sa cripteze parola - MD5. Inainte sa fie bagata in baza de date, aceasta este criptata, iar cand se compara este ceva de genul (deja criptata)parolaBazaDate == md5(parolaIntrodusa), adica se compara hashurile, nu se decripteaza cum as fi crezut.

#### SUPER BUG! Cand am transferat proiectul de la Alex la mine pentru prezentare, acesta nu ruleaza. Se builduieste frumos, dar nu ruleaza nimic. Foarte urat. Am stat o ora jumatate incercand sa gasesc solutia, dar nimic. madafaca

### Alex

In android studio am creat pagina de start care este un layout care contine o lista de anunturi cate unul pe rand , un anunt este alcatuit dintr o imagine si un txt in drapta ,imaginea fiind una dintre imaginele anuntului iar txt-ul fiind o parte din descriere.
Cand facem click pe un anunt din aceasta lista se deschide anuntul propiu zis care este alcatuit dintr-un scroll viwe de imagini un txt care reprezinta descrierea un timer care arata cand timp mai este pana anuntul va fi inchis ,pretul actual al licitatie si un loc in care poti face bid.


### Teo

Odata ce a fost creeata baza de date am inceput prin a construi obiecul Anunt care mapeaza campurile din baza de date. Apoi interfata de UserService si UserServiceImpl ca implementare a ei.
Am creeat functiile necesare , update, add, delete, findById .Am testat functiile creeate si conexiunea si inereactiunea cu baza de date
Am incercat sa fac automation test dar am intampinat probleme la transferul proiectului si nu am reusit sa le rezolv 
