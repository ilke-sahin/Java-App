package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class PlayActivity extends AppCompatActivity {
    String[] questions = {
            "1. Java'da bir değişkenin değerini nasıl değiştirirsiniz?",
            "2. Bir Android aktivitesinden diğerine nasıl geçiş yapılır?",
            "3. XML dosyasında bir butona tıklanınca ne tür bir olay tetiklenir?",
            "4. Android Studio'da bir yeni proje nasıl oluşturulur?",
            "5. Bir Android uygulamasında kullanıcıdan veri nasıl alınır?",
            "6. Intent nedir ve ne işe yarar?",
            "7. Android'de bir ImageView'a resim nasıl eklenir?",
            "8. XML dosyasında layout_width ve layout_height nedir?",
            "9. Android'de Toast mesajı nasıl gösterilir?",
            "10. Bir Android projesinde R.java dosyası ne işe yarar?",
            "11. Bir döngüyü sonlandırmak için kullanılan anahtar kelime nedir?",
            "12. Android'de bir liste görünümü nasıl oluşturulur?",
            "13. findViewById() metodunun amacı nedir?",
            "14. Bir Java sınıfı nasıl tanımlanır?",
            "15. Android'de bir AlertDialog nasıl gösterilir?",
            "16. Hangi veri türü ondalık sayıları temsil eder?",
            "17. Bir Java sınıfındaki bir metot nasıl çağrılır?",
            "18. Bir Android uygulamasında manifest dosyası ne işe yarar?",
            "19. XML dosyasında kullanılan xmlns nedir?",
            "20. Bir Android projesinde drawable klasörü hangi türde dosyalar içerir?"
    };

    String[] options = {
            "A) setVariable()", "B) changeValue()", "C) modifyVariable()", "D) setValue()",
            "A) switchActivity()", "B) startNewActivity()", "C) changeIntent()", "D) startActivity()",
            "A) onClickEvent", "B) onLongClickEvent", "C) onTouchEvent", "D) onItemSelectedEvent",
            "A) File > New > Project", "B) Project > New > Android", "C) Run > New > App", "D) Tools > New > Application",
            "A) getUserData()", "B) retrieveData()", "C) getDataFromUser()", "D) EditText.getText()",
            "A) Bir Android uygulamasını başlatmak için kullanılan bir sınıf.", "B) Bir metodu çağırmak için kullanılan bir nesne.", "C) İki farklı aktivite arasında veri iletimini sağlayan bir nesne.", "D) Ekran üzerindeki butonları temsil eden bir sınıf.",
            "A) setImageSource()", "B) setDrawable()", "C) setImage()", "D) srcProperty()",
            "A) Genişlik ve yükseklik ayarları", "B) Z-index ayarları", "C) Renk ve stil ayarları", "D) Font ve tipografi ayarları",
            "A) showToastMessage()", "B) displayToast()", "C) makeToast()", "D) Toast.makeText()",
            "A) Kullanıcı ara yüzü öğelerini tanımlar.", "B) Proje içindeki resimleri depolar.", "C) Rengi temsil eder.", "D) Uygulama içindeki veritabanını tanımlar.",
            "A) stop", "B) break", "C) exit", "D) quit",
            "A) ListView", "B) RecyclerView", "C) GridView", "D) ScrollView",
            "A) Arayüz öğelerini tanımlamak için.", "B) Uygulama içindeki resimleri tanımlamak için.", "C) Öğeler arasındaki ilişkileri tanımlamak için.", "D) Bir sınıfı tanımlamak için.",
            "A) class", "B) method", "C) object", "D) variable",
            "A) showAlertDiaWlog()", "B) createDialog()", "C) displayAlert()", "D) AlertDialog.show()",
            "A) float", "B) int", "C) double", "D) decimal",
            "A) Call.methodName()", "B) invoke.method()", "C) execute.methodName()", "D) methodName()",
            "A) Uygulamanın giriş noktasını belirler.", "B) Uygulamanın bileşenlerini listeler.", "C) Uygulamanın kaynak dosyalarını içerir.", "D) Uygulamanın düzenini belirler.",
            "A) XML dosyasının namespace'ini tanımlar.", "B) XML dosyasının stilini tanımlar.", "C) XML dosyasının versiyonunu belirler.", "D) XML dosyasının elemanlarını gruplar.",
            "A) Arka plan resimleri", "B) XML dosyaları", "C) Java sınıfları", "D) Veritabanı dosyaları"
    };

    String[] correctAnswers = {
            "D) setValue()",
            "D) startActivity()",
            "A) onClickEvent",
            "A) File > New > Project",
            "D) EditText.getText()",
            "C) İki farklı aktivite arasında veri iletimini sağlayan bir nesne.",
            "C) setImage()",
            "A) Genişlik ve yükseklik ayarları",
            "D) Toast.makeText()",
            "A) Kullanıcı ara yüzü öğelerini tanımlar.",
            "B) break",
            "B) RecyclerView",
            "A) Arayüz öğelerini tanımlamak için.",
            "A) class",
            "D) AlertDialog.show()",
            "C) double",
            "D) methodName()",
            "A) Uygulamanın giriş noktasını belirler.",
            "A) XML dosyasının namespace'ini tanımlar.",
            "A) Arka plan resimleri"
    };

    TextView questionCounterTextView, questionTextView;
    Button optionButton1, optionButton2, optionButton3, optionButton4, nextButton;

    int currentQuestionIndex = 0;
    int playerScore = 0;
    boolean isButtonClicked = false;
    String selectedOption = "";
    Button clickedButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        questionCounterTextView = findViewById(R.id.cpt_question);
        questionTextView = findViewById(R.id.text_question);

        optionButton1 = findViewById(R.id.btn_choose1);
        optionButton2 = findViewById(R.id.btn_choose2);
        optionButton3 = findViewById(R.id.btn_choose3);
        optionButton4 = findViewById(R.id.btn_choose4);
        nextButton = findViewById(R.id.btn_next);

        findViewById(R.id.image_back).setOnClickListener(
                a -> finish()
        );

        displayQuestionAndOptions();

        nextButton.setOnClickListener(
                view -> {
                    if (isButtonClicked) {
                        isButtonClicked = false;

                        if (!selectedOption.equals(correctAnswers[currentQuestionIndex])) {
                            Toast.makeText(PlayActivity.this, "Wrong", Toast.LENGTH_LONG).show();
                            clickedButton.setBackgroundResource(R.drawable.background_btn_error);
                        } else {
                            Toast.makeText(PlayActivity.this, "Correct", Toast.LENGTH_LONG).show();
                            clickedButton.setBackgroundResource(R.drawable.background_btn_correct);
                            playerScore++;
                        }

                        new Handler().postDelayed(() -> {
                            if (currentQuestionIndex != questions.length - 1) {
                                currentQuestionIndex++;
                                displayQuestionAndOptions();
                                selectedOption = "";
                                optionButton1.setBackgroundResource(R.drawable.background_btn_choose);
                                optionButton2.setBackgroundResource(R.drawable.background_btn_choose);
                                optionButton3.setBackgroundResource(R.drawable.background_btn_choose);
                                optionButton4.setBackgroundResource(R.drawable.background_btn_choose);
                            } else {
                                Intent intent = new Intent(PlayActivity.this, ResultActivity.class);
                                intent.putExtra("Result", playerScore);
                                startActivity(intent);
                                finish();
                            }
                        }, 2000);

                    } else {
                        Toast.makeText(PlayActivity.this, "You must choose one", Toast.LENGTH_LONG).show();
                    }
                }
        );
    }

    void displayQuestionAndOptions() {
        questionCounterTextView.setText((currentQuestionIndex + 1) + "/" + questions.length);
        questionTextView.setText(questions[currentQuestionIndex]);

        optionButton1.setText(options[4 * currentQuestionIndex]);
        optionButton2.setText(options[4 * currentQuestionIndex + 1]);
        optionButton3.setText(options[4 * currentQuestionIndex + 2]);
        optionButton4.setText(options[4 * currentQuestionIndex + 3]);
    }

    public void onOptionButtonClick(View view) {
        clickedButton = (Button) view;

        if (isButtonClicked) {
            optionButton1.setBackgroundResource(R.drawable.background_btn_choose);
            optionButton2.setBackgroundResource(R.drawable.background_btn_choose);
            optionButton3.setBackgroundResource(R.drawable.background_btn_choose);
            optionButton4.setBackgroundResource(R.drawable.background_btn_choose);
        }
        handleButtonClick();
    }

    void handleButtonClick() {
        clickedButton.setBackgroundResource(R.drawable.background_btn_choose_color);
        isButtonClicked = true;
        selectedOption = clickedButton.getText().toString();
    }
}
