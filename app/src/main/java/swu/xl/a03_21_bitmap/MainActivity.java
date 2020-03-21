package swu.xl.a03_21_bitmap;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //根据图片生成原位图，不能直接对原位图进行操作
        Bitmap orgBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.head);

        //创建了一个和原位图一样大小，基本设置一样的空白位图
        Bitmap copBitmap = Bitmap.createBitmap(orgBitmap.getWidth(), orgBitmap.getHeight(), orgBitmap.getConfig());

        //根据matrix将原位图画到空白位图里
        Canvas canvas = new Canvas(copBitmap);
        Matrix matrix = new Matrix();
        //操作
        //matrix.setTranslate(500,500);
        //matrix.setScale(0.5f,0.5f);
        //matrix.setRotate(45,0,0);
        Paint paint = new Paint();
        canvas.drawBitmap(orgBitmap,matrix,paint);

        //设置图片
        ImageView imgView = (ImageView) findViewById(R.id.img);
        imgView.setImageBitmap(copBitmap);
    }
}
