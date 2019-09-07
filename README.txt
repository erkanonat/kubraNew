
Bu uygulama , java programlama dilinde yazılmış web tabanlı bir uygulamadır.
kullanılan teknolojiler :

-java
-springMVC
-maven
-mysql
-primeface
-jsf

uygulamayı sıfırdan kurarken,  running durumda bir mysql service miz olmalı .
kullanıcı root ve password root1234 olarak ayarlanmıştır. springapp-servlet.xml dosyasından configuration ayarlanabilir DB için.
url, port , username ve password bilgiler.
default olarak 127.0.0.1:3306  setlidir.

create_Table.sql dosyasını src/resources altında bulabilirsiniz. bu tabloların db de yaratılmış olması gereklidir.

uygulamayı build edip (mvn clean install) war paketi aldıktan sonra, oluşan war uzantılı paketi herhangi bir uygulama sunucuna (Tomcat 8.5 kullandım testlerim sırasında) deploy edebilirsiniz.

browser dan : http://localhost:8080/kubraNew_war/
url ine giderek (local sunucu için) login ekranının geldiği görülebilir. .

sign-up ile user oluşturup, login olduktan sonra uygulama kullanılabilir.




