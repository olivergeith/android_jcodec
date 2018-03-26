
package org.jcodec.api.android;

import java.io.File;
import java.io.IOException;

import org.jcodec.api.SequenceEncoder;
import org.jcodec.common.Codec;
import org.jcodec.common.Format;
import org.jcodec.common.io.NIOUtils;
import org.jcodec.common.io.SeekableByteChannel;
import org.jcodec.common.model.Rational;
import org.jcodec.scale.BitmapUtil;

import android.graphics.Bitmap;

/**
 * This class is part of JCodec ( www.jcodec.org ) This software is distributed
 * under FreeBSD License
 * 
 * @author The JCodec project
 * 
 */
public class AndroidSequenceEncoder extends SequenceEncoder {

    public static AndroidSequenceEncoder createSequenceEncoder(final File out, final int fps) throws IOException {
        return new AndroidSequenceEncoder(NIOUtils.writableChannel(out), Rational.R(fps, 1));
    }

    public static AndroidSequenceEncoder create25Fps(final File out) throws IOException {
        return new AndroidSequenceEncoder(NIOUtils.writableChannel(out), Rational.R(25, 1));
    }

    public static AndroidSequenceEncoder create30Fps(final File out) throws IOException {
        return new AndroidSequenceEncoder(NIOUtils.writableChannel(out), Rational.R(30, 1));
    }

    public static AndroidSequenceEncoder create2997Fps(final File out) throws IOException {
        return new AndroidSequenceEncoder(NIOUtils.writableChannel(out), Rational.R(30000, 1001));
    }

    public static AndroidSequenceEncoder create24Fps(final File out) throws IOException {
        return new AndroidSequenceEncoder(NIOUtils.writableChannel(out), Rational.R(24, 1));
    }

    public AndroidSequenceEncoder(final SeekableByteChannel ch, final Rational fps) throws IOException {
        super(ch, fps, Format.MKV, Codec.H264, null);
    }

    public void encodeImage(final Bitmap bi) throws IOException {
        encodeNativeFrame(BitmapUtil.fromBitmap(bi));
    }
}