package io.c0nnector.github.sampleapp.views;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.widget.ImageView;

import io.c0nnector.github.sampleapp.R;

public class TintableImageView extends ImageView {

    private ColorStateList tint;

    public TintableImageView(Context context) {
        super(context);
    }

    public TintableImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs, 0);
    }

    public TintableImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context, attrs, defStyle);
    }

    private void init(Context context, AttributeSet attrs, int defStyle) {
        if (isInEditMode()) return;

        TypedArray typedArray = context.obtainStyledAttributes(
                attrs,
                R.styleable.TintableImageView,
                defStyle,
                0
        );

        tint = typedArray.getColorStateList(R.styleable.TintableImageView_tint);

        typedArray.recycle();
    }

    @Override
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (tint != null) {
            setColorFilter(tint.getColorForState(getDrawableState(), tint.getDefaultColor()), PorterDuff.Mode.SRC_ATOP);
        }
    }
}
