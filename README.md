
<h1>MangaMark<img src="https://user-images.githubusercontent.com/48556068/59041333-c2e31780-884e-11e9-94b9-893494094279.png" width="45" height="45"></h1>

MangaMark é um Bookmark de Mangás, que possui uma biblioteca com uma lista de mangás possibilitando o usuario a adiciona-lá a sua lista, para assim acompanhar os mángas que estão sendo lidos.


##Implementations

   def room_version = "2.2.5"
   implementation "androidx.room:room-runtime:$room_version"
   kapt "androidx.room:room-compiler:$room_version"
   implementation "androidx.room:room-ktx:$room_version"
   testImplementation "androidx.room:room-testing:$room_version"

   implementation 'androidx.legacy:legacy-support-v4:1.0.0'
   implementation 'androidx.navigation:navigation-fragment-ktx:2.3.0'
   implementation 'androidx.navigation:navigation-ui-ktx:2.3.0'

   implementation 'com.squareup.retrofit2:retrofit:2.9.0'
   implementation 'com.squareup.retrofit2:converter-gson:2.9.0'
   implementation 'com.google.code.gson:gson:2.8.6'

   implementation 'com.squareup.picasso:picasso:2.71828'

   implementation 'com.google.android.material:material:1.3.0-alpha02'


## Funcionalidades

- Logar  								-> Activity,Retrofit,Room,API.
- Registrar 							-> Activity,Retrofit,Room,API.
- Listar Mangás.						-> Activity,Fragments,Retrofit,Room,API,Picaso,Material.io.
- Inserir Mangás a sua Lista Pessoal.	-> Fragment,Card,Retrofit,Room,API.
- Remover Mangás de sua Lista Pessoal.	-> Fragment,Card,Retrofit,Room,API.
- Registrar sua Leitura.				-> Fragment,Card,Retrofit,Room,API.

## Diagrama

<img src="https://i.imgur.com/lTCg5EE.png" width="700" height="800">
