package de.jevopi.mitra2.parser.antlr.lexer;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalMitraLexer extends Lexer {
    public static final int RULE_ID=101;
    public static final int RULE_ANY_OTHER=107;
    public static final int KEYWORD_56=53;
    public static final int KEYWORD_55=52;
    public static final int KEYWORD_54=51;
    public static final int KEYWORD_53=50;
    public static final int KEYWORD_52=49;
    public static final int KEYWORD_51=48;
    public static final int KEYWORD_50=47;
    public static final int EOF=-1;
    public static final int KEYWORD_59=35;
    public static final int KEYWORD_58=55;
    public static final int KEYWORD_57=54;
    public static final int KEYWORD_65=41;
    public static final int KEYWORD_64=40;
    public static final int KEYWORD_67=27;
    public static final int KEYWORD_66=26;
    public static final int KEYWORD_61=37;
    public static final int KEYWORD_60=36;
    public static final int KEYWORD_63=39;
    public static final int KEYWORD_62=38;
    public static final int KEYWORD_69=29;
    public static final int KEYWORD_68=28;
    public static final int KEYWORD_30=73;
    public static final int KEYWORD_34=77;
    public static final int KEYWORD_33=76;
    public static final int KEYWORD_32=75;
    public static final int KEYWORD_31=74;
    public static final int KEYWORD_38=57;
    public static final int KEYWORD_37=56;
    public static final int KEYWORD_36=79;
    public static final int KEYWORD_35=78;
    public static final int RULE_ML_COMMENT=104;
    public static final int KEYWORD_39=58;
    public static final int RULE_STRING=103;
    public static final int KEYWORD_41=60;
    public static final int KEYWORD_40=59;
    public static final int KEYWORD_43=62;
    public static final int KEYWORD_42=61;
    public static final int KEYWORD_45=42;
    public static final int KEYWORD_44=63;
    public static final int KEYWORD_47=44;
    public static final int KEYWORD_46=43;
    public static final int KEYWORD_49=46;
    public static final int KEYWORD_48=45;
    public static final int KEYWORD_93=6;
    public static final int KEYWORD_94=7;
    public static final int KEYWORD_95=8;
    public static final int KEYWORD_96=9;
    public static final int KEYWORD_19=98;
    public static final int KEYWORD_90=12;
    public static final int KEYWORD_17=96;
    public static final int KEYWORD_92=5;
    public static final int KEYWORD_18=97;
    public static final int KEYWORD_91=4;
    public static final int KEYWORD_15=94;
    public static final int KEYWORD_16=95;
    public static final int KEYWORD_13=92;
    public static final int KEYWORD_14=93;
    public static final int KEYWORD_11=90;
    public static final int KEYWORD_12=91;
    public static final int KEYWORD_10=89;
    public static final int KEYWORD_6=85;
    public static final int KEYWORD_7=86;
    public static final int KEYWORD_8=87;
    public static final int KEYWORD_9=88;
    public static final int KEYWORD_28=71;
    public static final int KEYWORD_29=72;
    public static final int RULE_INT=102;
    public static final int KEYWORD_24=67;
    public static final int KEYWORD_25=68;
    public static final int KEYWORD_26=69;
    public static final int KEYWORD_27=70;
    public static final int KEYWORD_20=99;
    public static final int KEYWORD_21=64;
    public static final int KEYWORD_22=65;
    public static final int KEYWORD_23=66;
    public static final int KEYWORD_79=21;
    public static final int KEYWORD_71=31;
    public static final int KEYWORD_72=32;
    public static final int KEYWORD_73=33;
    public static final int KEYWORD_74=34;
    public static final int KEYWORD_75=17;
    public static final int KEYWORD_76=18;
    public static final int KEYWORD_77=19;
    public static final int KEYWORD_78=20;
    public static final int KEYWORD_1=80;
    public static final int KEYWORD_5=84;
    public static final int KEYWORD_4=83;
    public static final int KEYWORD_70=30;
    public static final int KEYWORD_3=82;
    public static final int KEYWORD_2=81;
    public static final int RULE_FLOAT=100;
    public static final int RULE_SL_COMMENT=105;
    public static final int KEYWORD_84=13;
    public static final int KEYWORD_85=14;
    public static final int KEYWORD_82=24;
    public static final int KEYWORD_83=25;
    public static final int KEYWORD_88=10;
    public static final int KEYWORD_89=11;
    public static final int KEYWORD_86=15;
    public static final int KEYWORD_87=16;
    public static final int KEYWORD_81=23;
    public static final int KEYWORD_80=22;
    public static final int RULE_WS=106;

    // delegates
    // delegators

    public InternalMitraLexer() {;} 
    public InternalMitraLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public InternalMitraLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g"; }

    // $ANTLR start "KEYWORD_91"
    public final void mKEYWORD_91() throws RecognitionException {
        try {
            int _type = KEYWORD_91;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:19:12: ( 'Collection' )
            // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:19:14: 'Collection'
            {
            match("Collection"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_91"

    // $ANTLR start "KEYWORD_92"
    public final void mKEYWORD_92() throws RecognitionException {
        try {
            int _type = KEYWORD_92;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:21:12: ( 'OrderedSet' )
            // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:21:14: 'OrderedSet'
            {
            match("OrderedSet"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_92"

    // $ANTLR start "KEYWORD_93"
    public final void mKEYWORD_93() throws RecognitionException {
        try {
            int _type = KEYWORD_93;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:23:12: ( 'annotation' )
            // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:23:14: 'annotation'
            {
            match("annotation"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_93"

    // $ANTLR start "KEYWORD_94"
    public final void mKEYWORD_94() throws RecognitionException {
        try {
            int _type = KEYWORD_94;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:25:12: ( 'excludedBy' )
            // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:25:14: 'excludedBy'
            {
            match("excludedBy"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_94"

    // $ANTLR start "KEYWORD_95"
    public final void mKEYWORD_95() throws RecognitionException {
        try {
            int _type = KEYWORD_95;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:27:12: ( 'implements' )
            // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:27:14: 'implements'
            {
            match("implements"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_95"

    // $ANTLR start "KEYWORD_96"
    public final void mKEYWORD_96() throws RecognitionException {
        try {
            int _type = KEYWORD_96;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:29:12: ( 'instanceof' )
            // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:29:14: 'instanceof'
            {
            match("instanceof"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_96"

    // $ANTLR start "KEYWORD_88"
    public final void mKEYWORD_88() throws RecognitionException {
        try {
            int _type = KEYWORD_88;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:31:12: ( 'metamodel' )
            // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:31:14: 'metamodel'
            {
            match("metamodel"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_88"

    // $ANTLR start "KEYWORD_89"
    public final void mKEYWORD_89() throws RecognitionException {
        try {
            int _type = KEYWORD_89;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:33:12: ( 'overrides' )
            // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:33:14: 'overrides'
            {
            match("overrides"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_89"

    // $ANTLR start "KEYWORD_90"
    public final void mKEYWORD_90() throws RecognitionException {
        try {
            int _type = KEYWORD_90;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:35:12: ( 'parameter' )
            // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:35:14: 'parameter'
            {
            match("parameter"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_90"

    // $ANTLR start "KEYWORD_84"
    public final void mKEYWORD_84() throws RecognitionException {
        try {
            int _type = KEYWORD_84;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:37:12: ( 'Sequence' )
            // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:37:14: 'Sequence'
            {
            match("Sequence"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_84"

    // $ANTLR start "KEYWORD_85"
    public final void mKEYWORD_85() throws RecognitionException {
        try {
            int _type = KEYWORD_85;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:39:12: ( 'abstract' )
            // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:39:14: 'abstract'
            {
            match("abstract"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_85"

    // $ANTLR start "KEYWORD_86"
    public final void mKEYWORD_86() throws RecognitionException {
        try {
            int _type = KEYWORD_86;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:41:12: ( 'replaces' )
            // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:41:14: 'replaces'
            {
            match("replaces"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_86"

    // $ANTLR start "KEYWORD_87"
    public final void mKEYWORD_87() throws RecognitionException {
        try {
            int _type = KEYWORD_87;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:43:12: ( 'required' )
            // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:43:14: 'required'
            {
            match("required"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_87"

    // $ANTLR start "KEYWORD_75"
    public final void mKEYWORD_75() throws RecognitionException {
        try {
            int _type = KEYWORD_75;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:45:12: ( 'boolean' )
            // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:45:14: 'boolean'
            {
            match("boolean"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_75"

    // $ANTLR start "KEYWORD_76"
    public final void mKEYWORD_76() throws RecognitionException {
        try {
            int _type = KEYWORD_76;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:47:12: ( 'confirm' )
            // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:47:14: 'confirm'
            {
            match("confirm"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_76"

    // $ANTLR start "KEYWORD_77"
    public final void mKEYWORD_77() throws RecognitionException {
        try {
            int _type = KEYWORD_77;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:49:12: ( 'default' )
            // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:49:14: 'default'
            {
            match("default"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_77"

    // $ANTLR start "KEYWORD_78"
    public final void mKEYWORD_78() throws RecognitionException {
        try {
            int _type = KEYWORD_78;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:51:12: ( 'finally' )
            // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:51:14: 'finally'
            {
            match("finally"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_78"

    // $ANTLR start "KEYWORD_79"
    public final void mKEYWORD_79() throws RecognitionException {
        try {
            int _type = KEYWORD_79;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:53:12: ( 'package' )
            // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:53:14: 'package'
            {
            match("package"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_79"

    // $ANTLR start "KEYWORD_80"
    public final void mKEYWORD_80() throws RecognitionException {
        try {
            int _type = KEYWORD_80;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:55:12: ( 'private' )
            // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:55:14: 'private'
            {
            match("private"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_80"

    // $ANTLR start "KEYWORD_81"
    public final void mKEYWORD_81() throws RecognitionException {
        try {
            int _type = KEYWORD_81;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:57:12: ( 'stealth' )
            // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:57:14: 'stealth'
            {
            match("stealth"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_81"

    // $ANTLR start "KEYWORD_82"
    public final void mKEYWORD_82() throws RecognitionException {
        try {
            int _type = KEYWORD_82;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:59:12: ( 'trigger' )
            // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:59:14: 'trigger'
            {
            match("trigger"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_82"

    // $ANTLR start "KEYWORD_83"
    public final void mKEYWORD_83() throws RecognitionException {
        try {
            int _type = KEYWORD_83;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:61:12: ( 'virtual' )
            // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:61:14: 'virtual'
            {
            match("virtual"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_83"

    // $ANTLR start "KEYWORD_66"
    public final void mKEYWORD_66() throws RecognitionException {
        try {
            int _type = KEYWORD_66;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:63:12: ( 'String' )
            // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:63:14: 'String'
            {
            match("String"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_66"

    // $ANTLR start "KEYWORD_67"
    public final void mKEYWORD_67() throws RecognitionException {
        try {
            int _type = KEYWORD_67;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:65:12: ( 'called' )
            // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:65:14: 'called'
            {
            match("called"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_67"

    // $ANTLR start "KEYWORD_68"
    public final void mKEYWORD_68() throws RecognitionException {
        try {
            int _type = KEYWORD_68;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:67:12: ( 'create' )
            // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:67:14: 'create'
            {
            match("create"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_68"

    // $ANTLR start "KEYWORD_69"
    public final void mKEYWORD_69() throws RecognitionException {
        try {
            int _type = KEYWORD_69;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:69:12: ( 'import' )
            // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:69:14: 'import'
            {
            match("import"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_69"

    // $ANTLR start "KEYWORD_70"
    public final void mKEYWORD_70() throws RecognitionException {
        try {
            int _type = KEYWORD_70;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:71:12: ( 'manual' )
            // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:71:14: 'manual'
            {
            match("manual"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_70"

    // $ANTLR start "KEYWORD_71"
    public final void mKEYWORD_71() throws RecognitionException {
        try {
            int _type = KEYWORD_71;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:73:12: ( 'module' )
            // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:73:14: 'module'
            {
            match("module"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_71"

    // $ANTLR start "KEYWORD_72"
    public final void mKEYWORD_72() throws RecognitionException {
        try {
            int _type = KEYWORD_72;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:75:12: ( 'public' )
            // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:75:14: 'public'
            {
            match("public"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_72"

    // $ANTLR start "KEYWORD_73"
    public final void mKEYWORD_73() throws RecognitionException {
        try {
            int _type = KEYWORD_73;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:77:12: ( 'return' )
            // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:77:14: 'return'
            {
            match("return"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_73"

    // $ANTLR start "KEYWORD_74"
    public final void mKEYWORD_74() throws RecognitionException {
        try {
            int _type = KEYWORD_74;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:79:12: ( 'traced' )
            // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:79:14: 'traced'
            {
            match("traced"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_74"

    // $ANTLR start "KEYWORD_59"
    public final void mKEYWORD_59() throws RecognitionException {
        try {
            int _type = KEYWORD_59;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:81:12: ( 'break' )
            // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:81:14: 'break'
            {
            match("break"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_59"

    // $ANTLR start "KEYWORD_60"
    public final void mKEYWORD_60() throws RecognitionException {
        try {
            int _type = KEYWORD_60;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:83:12: ( 'catch' )
            // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:83:14: 'catch'
            {
            match("catch"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_60"

    // $ANTLR start "KEYWORD_61"
    public final void mKEYWORD_61() throws RecognitionException {
        try {
            int _type = KEYWORD_61;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:85:12: ( 'false' )
            // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:85:14: 'false'
            {
            match("false"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_61"

    // $ANTLR start "KEYWORD_62"
    public final void mKEYWORD_62() throws RecognitionException {
        try {
            int _type = KEYWORD_62;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:87:12: ( 'multi' )
            // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:87:14: 'multi'
            {
            match("multi"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_62"

    // $ANTLR start "KEYWORD_63"
    public final void mKEYWORD_63() throws RecognitionException {
        try {
            int _type = KEYWORD_63;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:89:12: ( 'super' )
            // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:89:14: 'super'
            {
            match("super"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_63"

    // $ANTLR start "KEYWORD_64"
    public final void mKEYWORD_64() throws RecognitionException {
        try {
            int _type = KEYWORD_64;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:91:12: ( 'throw' )
            // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:91:14: 'throw'
            {
            match("throw"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_64"

    // $ANTLR start "KEYWORD_65"
    public final void mKEYWORD_65() throws RecognitionException {
        try {
            int _type = KEYWORD_65;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:93:12: ( 'while' )
            // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:93:14: 'while'
            {
            match("while"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_65"

    // $ANTLR start "KEYWORD_45"
    public final void mKEYWORD_45() throws RecognitionException {
        try {
            int _type = KEYWORD_45;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:95:12: ( 'Type' )
            // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:95:14: 'Type'
            {
            match("Type"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_45"

    // $ANTLR start "KEYWORD_46"
    public final void mKEYWORD_46() throws RecognitionException {
        try {
            int _type = KEYWORD_46;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:97:12: ( 'auto' )
            // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:97:14: 'auto'
            {
            match("auto"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_46"

    // $ANTLR start "KEYWORD_47"
    public final void mKEYWORD_47() throws RecognitionException {
        try {
            int _type = KEYWORD_47;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:99:12: ( 'else' )
            // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:99:14: 'else'
            {
            match("else"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_47"

    // $ANTLR start "KEYWORD_48"
    public final void mKEYWORD_48() throws RecognitionException {
        try {
            int _type = KEYWORD_48;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:101:12: ( 'from' )
            // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:101:14: 'from'
            {
            match("from"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_48"

    // $ANTLR start "KEYWORD_49"
    public final void mKEYWORD_49() throws RecognitionException {
        try {
            int _type = KEYWORD_49;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:103:12: ( 'into' )
            // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:103:14: 'into'
            {
            match("into"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_49"

    // $ANTLR start "KEYWORD_50"
    public final void mKEYWORD_50() throws RecognitionException {
        try {
            int _type = KEYWORD_50;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:105:12: ( 'java' )
            // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:105:14: 'java'
            {
            match("java"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_50"

    // $ANTLR start "KEYWORD_51"
    public final void mKEYWORD_51() throws RecognitionException {
        try {
            int _type = KEYWORD_51;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:107:12: ( 'null' )
            // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:107:14: 'null'
            {
            match("null"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_51"

    // $ANTLR start "KEYWORD_52"
    public final void mKEYWORD_52() throws RecognitionException {
        try {
            int _type = KEYWORD_52;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:109:12: ( 'real' )
            // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:109:14: 'real'
            {
            match("real"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_52"

    // $ANTLR start "KEYWORD_53"
    public final void mKEYWORD_53() throws RecognitionException {
        try {
            int _type = KEYWORD_53;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:111:12: ( 'rule' )
            // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:111:14: 'rule'
            {
            match("rule"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_53"

    // $ANTLR start "KEYWORD_54"
    public final void mKEYWORD_54() throws RecognitionException {
        try {
            int _type = KEYWORD_54;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:113:12: ( 'self' )
            // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:113:14: 'self'
            {
            match("self"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_54"

    // $ANTLR start "KEYWORD_55"
    public final void mKEYWORD_55() throws RecognitionException {
        try {
            int _type = KEYWORD_55;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:115:12: ( 'true' )
            // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:115:14: 'true'
            {
            match("true"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_55"

    // $ANTLR start "KEYWORD_56"
    public final void mKEYWORD_56() throws RecognitionException {
        try {
            int _type = KEYWORD_56;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:117:12: ( 'void' )
            // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:117:14: 'void'
            {
            match("void"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_56"

    // $ANTLR start "KEYWORD_57"
    public final void mKEYWORD_57() throws RecognitionException {
        try {
            int _type = KEYWORD_57;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:119:12: ( 'when' )
            // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:119:14: 'when'
            {
            match("when"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_57"

    // $ANTLR start "KEYWORD_58"
    public final void mKEYWORD_58() throws RecognitionException {
        try {
            int _type = KEYWORD_58;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:121:12: ( 'with' )
            // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:121:14: 'with'
            {
            match("with"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_58"

    // $ANTLR start "KEYWORD_37"
    public final void mKEYWORD_37() throws RecognitionException {
        try {
            int _type = KEYWORD_37;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:123:12: ( 'Bag' )
            // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:123:14: 'Bag'
            {
            match("Bag"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_37"

    // $ANTLR start "KEYWORD_38"
    public final void mKEYWORD_38() throws RecognitionException {
        try {
            int _type = KEYWORD_38;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:125:12: ( 'Set' )
            // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:125:14: 'Set'
            {
            match("Set"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_38"

    // $ANTLR start "KEYWORD_39"
    public final void mKEYWORD_39() throws RecognitionException {
        try {
            int _type = KEYWORD_39;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:127:12: ( 'any' )
            // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:127:14: 'any'
            {
            match("any"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_39"

    // $ANTLR start "KEYWORD_40"
    public final void mKEYWORD_40() throws RecognitionException {
        try {
            int _type = KEYWORD_40;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:129:12: ( 'for' )
            // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:129:14: 'for'
            {
            match("for"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_40"

    // $ANTLR start "KEYWORD_41"
    public final void mKEYWORD_41() throws RecognitionException {
        try {
            int _type = KEYWORD_41;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:131:12: ( 'int' )
            // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:131:14: 'int'
            {
            match("int"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_41"

    // $ANTLR start "KEYWORD_42"
    public final void mKEYWORD_42() throws RecognitionException {
        try {
            int _type = KEYWORD_42;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:133:12: ( 'new' )
            // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:133:14: 'new'
            {
            match("new"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_42"

    // $ANTLR start "KEYWORD_43"
    public final void mKEYWORD_43() throws RecognitionException {
        try {
            int _type = KEYWORD_43;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:135:12: ( 'try' )
            // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:135:14: 'try'
            {
            match("try"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_43"

    // $ANTLR start "KEYWORD_44"
    public final void mKEYWORD_44() throws RecognitionException {
        try {
            int _type = KEYWORD_44;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:137:12: ( 'use' )
            // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:137:14: 'use'
            {
            match("use"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_44"

    // $ANTLR start "KEYWORD_21"
    public final void mKEYWORD_21() throws RecognitionException {
        try {
            int _type = KEYWORD_21;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:139:12: ( '!=' )
            // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:139:14: '!='
            {
            match("!="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_21"

    // $ANTLR start "KEYWORD_22"
    public final void mKEYWORD_22() throws RecognitionException {
        try {
            int _type = KEYWORD_22;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:141:12: ( '&&' )
            // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:141:14: '&&'
            {
            match("&&"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_22"

    // $ANTLR start "KEYWORD_23"
    public final void mKEYWORD_23() throws RecognitionException {
        try {
            int _type = KEYWORD_23;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:143:12: ( '++' )
            // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:143:14: '++'
            {
            match("++"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_23"

    // $ANTLR start "KEYWORD_24"
    public final void mKEYWORD_24() throws RecognitionException {
        try {
            int _type = KEYWORD_24;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:145:12: ( '+=' )
            // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:145:14: '+='
            {
            match("+="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_24"

    // $ANTLR start "KEYWORD_25"
    public final void mKEYWORD_25() throws RecognitionException {
        try {
            int _type = KEYWORD_25;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:147:12: ( '--' )
            // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:147:14: '--'
            {
            match("--"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_25"

    // $ANTLR start "KEYWORD_26"
    public final void mKEYWORD_26() throws RecognitionException {
        try {
            int _type = KEYWORD_26;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:149:12: ( '-=' )
            // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:149:14: '-='
            {
            match("-="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_26"

    // $ANTLR start "KEYWORD_27"
    public final void mKEYWORD_27() throws RecognitionException {
        try {
            int _type = KEYWORD_27;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:151:12: ( '->' )
            // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:151:14: '->'
            {
            match("->"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_27"

    // $ANTLR start "KEYWORD_28"
    public final void mKEYWORD_28() throws RecognitionException {
        try {
            int _type = KEYWORD_28;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:153:12: ( '::' )
            // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:153:14: '::'
            {
            match("::"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_28"

    // $ANTLR start "KEYWORD_29"
    public final void mKEYWORD_29() throws RecognitionException {
        try {
            int _type = KEYWORD_29;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:155:12: ( '<<' )
            // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:155:14: '<<'
            {
            match("<<"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_29"

    // $ANTLR start "KEYWORD_30"
    public final void mKEYWORD_30() throws RecognitionException {
        try {
            int _type = KEYWORD_30;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:157:12: ( '<=' )
            // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:157:14: '<='
            {
            match("<="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_30"

    // $ANTLR start "KEYWORD_31"
    public final void mKEYWORD_31() throws RecognitionException {
        try {
            int _type = KEYWORD_31;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:159:12: ( '==' )
            // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:159:14: '=='
            {
            match("=="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_31"

    // $ANTLR start "KEYWORD_32"
    public final void mKEYWORD_32() throws RecognitionException {
        try {
            int _type = KEYWORD_32;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:161:12: ( '>=' )
            // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:161:14: '>='
            {
            match(">="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_32"

    // $ANTLR start "KEYWORD_33"
    public final void mKEYWORD_33() throws RecognitionException {
        try {
            int _type = KEYWORD_33;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:163:12: ( '>>' )
            // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:163:14: '>>'
            {
            match(">>"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_33"

    // $ANTLR start "KEYWORD_34"
    public final void mKEYWORD_34() throws RecognitionException {
        try {
            int _type = KEYWORD_34;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:165:12: ( 'do' )
            // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:165:14: 'do'
            {
            match("do"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_34"

    // $ANTLR start "KEYWORD_35"
    public final void mKEYWORD_35() throws RecognitionException {
        try {
            int _type = KEYWORD_35;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:167:12: ( 'if' )
            // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:167:14: 'if'
            {
            match("if"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_35"

    // $ANTLR start "KEYWORD_36"
    public final void mKEYWORD_36() throws RecognitionException {
        try {
            int _type = KEYWORD_36;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:169:12: ( '||' )
            // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:169:14: '||'
            {
            match("||"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_36"

    // $ANTLR start "KEYWORD_1"
    public final void mKEYWORD_1() throws RecognitionException {
        try {
            int _type = KEYWORD_1;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:171:11: ( '!' )
            // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:171:13: '!'
            {
            match('!'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_1"

    // $ANTLR start "KEYWORD_2"
    public final void mKEYWORD_2() throws RecognitionException {
        try {
            int _type = KEYWORD_2;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:173:11: ( '$' )
            // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:173:13: '$'
            {
            match('$'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_2"

    // $ANTLR start "KEYWORD_3"
    public final void mKEYWORD_3() throws RecognitionException {
        try {
            int _type = KEYWORD_3;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:175:11: ( '&' )
            // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:175:13: '&'
            {
            match('&'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_3"

    // $ANTLR start "KEYWORD_4"
    public final void mKEYWORD_4() throws RecognitionException {
        try {
            int _type = KEYWORD_4;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:177:11: ( '(' )
            // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:177:13: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_4"

    // $ANTLR start "KEYWORD_5"
    public final void mKEYWORD_5() throws RecognitionException {
        try {
            int _type = KEYWORD_5;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:179:11: ( ')' )
            // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:179:13: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_5"

    // $ANTLR start "KEYWORD_6"
    public final void mKEYWORD_6() throws RecognitionException {
        try {
            int _type = KEYWORD_6;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:181:11: ( '*' )
            // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:181:13: '*'
            {
            match('*'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_6"

    // $ANTLR start "KEYWORD_7"
    public final void mKEYWORD_7() throws RecognitionException {
        try {
            int _type = KEYWORD_7;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:183:11: ( '+' )
            // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:183:13: '+'
            {
            match('+'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_7"

    // $ANTLR start "KEYWORD_8"
    public final void mKEYWORD_8() throws RecognitionException {
        try {
            int _type = KEYWORD_8;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:185:11: ( ',' )
            // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:185:13: ','
            {
            match(','); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_8"

    // $ANTLR start "KEYWORD_9"
    public final void mKEYWORD_9() throws RecognitionException {
        try {
            int _type = KEYWORD_9;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:187:11: ( '-' )
            // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:187:13: '-'
            {
            match('-'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_9"

    // $ANTLR start "KEYWORD_10"
    public final void mKEYWORD_10() throws RecognitionException {
        try {
            int _type = KEYWORD_10;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:189:12: ( '.' )
            // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:189:14: '.'
            {
            match('.'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_10"

    // $ANTLR start "KEYWORD_11"
    public final void mKEYWORD_11() throws RecognitionException {
        try {
            int _type = KEYWORD_11;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:191:12: ( '/' )
            // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:191:14: '/'
            {
            match('/'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_11"

    // $ANTLR start "KEYWORD_12"
    public final void mKEYWORD_12() throws RecognitionException {
        try {
            int _type = KEYWORD_12;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:193:12: ( ':' )
            // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:193:14: ':'
            {
            match(':'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_12"

    // $ANTLR start "KEYWORD_13"
    public final void mKEYWORD_13() throws RecognitionException {
        try {
            int _type = KEYWORD_13;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:195:12: ( ';' )
            // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:195:14: ';'
            {
            match(';'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_13"

    // $ANTLR start "KEYWORD_14"
    public final void mKEYWORD_14() throws RecognitionException {
        try {
            int _type = KEYWORD_14;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:197:12: ( '<' )
            // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:197:14: '<'
            {
            match('<'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_14"

    // $ANTLR start "KEYWORD_15"
    public final void mKEYWORD_15() throws RecognitionException {
        try {
            int _type = KEYWORD_15;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:199:12: ( '=' )
            // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:199:14: '='
            {
            match('='); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_15"

    // $ANTLR start "KEYWORD_16"
    public final void mKEYWORD_16() throws RecognitionException {
        try {
            int _type = KEYWORD_16;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:201:12: ( '>' )
            // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:201:14: '>'
            {
            match('>'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_16"

    // $ANTLR start "KEYWORD_17"
    public final void mKEYWORD_17() throws RecognitionException {
        try {
            int _type = KEYWORD_17;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:203:12: ( '@' )
            // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:203:14: '@'
            {
            match('@'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_17"

    // $ANTLR start "KEYWORD_18"
    public final void mKEYWORD_18() throws RecognitionException {
        try {
            int _type = KEYWORD_18;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:205:12: ( '{' )
            // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:205:14: '{'
            {
            match('{'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_18"

    // $ANTLR start "KEYWORD_19"
    public final void mKEYWORD_19() throws RecognitionException {
        try {
            int _type = KEYWORD_19;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:207:12: ( '|' )
            // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:207:14: '|'
            {
            match('|'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_19"

    // $ANTLR start "KEYWORD_20"
    public final void mKEYWORD_20() throws RecognitionException {
        try {
            int _type = KEYWORD_20;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:209:12: ( '}' )
            // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:209:14: '}'
            {
            match('}'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_20"

    // $ANTLR start "RULE_FLOAT"
    public final void mRULE_FLOAT() throws RecognitionException {
        try {
            int _type = RULE_FLOAT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:213:12: ( ( '0' .. '9' )* '.' ( '0' .. '9' )+ )
            // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:213:14: ( '0' .. '9' )* '.' ( '0' .. '9' )+
            {
            // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:213:14: ( '0' .. '9' )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>='0' && LA1_0<='9')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:213:15: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            match('.'); 
            // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:213:30: ( '0' .. '9' )+
            int cnt2=0;
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>='0' && LA2_0<='9')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:213:31: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    if ( cnt2 >= 1 ) break loop2;
                        EarlyExitException eee =
                            new EarlyExitException(2, input);
                        throw eee;
                }
                cnt2++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_FLOAT"

    // $ANTLR start "RULE_ID"
    public final void mRULE_ID() throws RecognitionException {
        try {
            int _type = RULE_ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:215:9: ( ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* )
            // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:215:11: ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            {
            // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:215:11: ( '^' )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0=='^') ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:215:11: '^'
                    {
                    match('^'); 

                    }
                    break;

            }

            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:215:40: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0>='0' && LA4_0<='9')||(LA4_0>='A' && LA4_0<='Z')||LA4_0=='_'||(LA4_0>='a' && LA4_0<='z')) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:
            	    {
            	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ID"

    // $ANTLR start "RULE_INT"
    public final void mRULE_INT() throws RecognitionException {
        try {
            int _type = RULE_INT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:217:10: ( ( '0' .. '9' )+ )
            // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:217:12: ( '0' .. '9' )+
            {
            // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:217:12: ( '0' .. '9' )+
            int cnt5=0;
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( ((LA5_0>='0' && LA5_0<='9')) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:217:13: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    if ( cnt5 >= 1 ) break loop5;
                        EarlyExitException eee =
                            new EarlyExitException(5, input);
                        throw eee;
                }
                cnt5++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_INT"

    // $ANTLR start "RULE_STRING"
    public final void mRULE_STRING() throws RecognitionException {
        try {
            int _type = RULE_STRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:219:13: ( ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' ) )
            // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:219:15: ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            {
            // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:219:15: ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0=='\"') ) {
                alt8=1;
            }
            else if ( (LA8_0=='\'') ) {
                alt8=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:219:16: '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"'
                    {
                    match('\"'); 
                    // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:219:20: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )*
                    loop6:
                    do {
                        int alt6=3;
                        int LA6_0 = input.LA(1);

                        if ( (LA6_0=='\\') ) {
                            alt6=1;
                        }
                        else if ( ((LA6_0>='\u0000' && LA6_0<='!')||(LA6_0>='#' && LA6_0<='[')||(LA6_0>=']' && LA6_0<='\uFFFF')) ) {
                            alt6=2;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:219:21: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' )
                    	    {
                    	    match('\\'); 
                    	    if ( input.LA(1)=='\"'||input.LA(1)=='\''||input.LA(1)=='\\'||input.LA(1)=='b'||input.LA(1)=='f'||input.LA(1)=='n'||input.LA(1)=='r'||(input.LA(1)>='t' && input.LA(1)<='u') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;}


                    	    }
                    	    break;
                    	case 2 :
                    	    // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:219:66: ~ ( ( '\\\\' | '\"' ) )
                    	    {
                    	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='!')||(input.LA(1)>='#' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFF') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;}


                    	    }
                    	    break;

                    	default :
                    	    break loop6;
                        }
                    } while (true);

                    match('\"'); 

                    }
                    break;
                case 2 :
                    // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:219:86: '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\''
                    {
                    match('\''); 
                    // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:219:91: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )*
                    loop7:
                    do {
                        int alt7=3;
                        int LA7_0 = input.LA(1);

                        if ( (LA7_0=='\\') ) {
                            alt7=1;
                        }
                        else if ( ((LA7_0>='\u0000' && LA7_0<='&')||(LA7_0>='(' && LA7_0<='[')||(LA7_0>=']' && LA7_0<='\uFFFF')) ) {
                            alt7=2;
                        }


                        switch (alt7) {
                    	case 1 :
                    	    // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:219:92: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' )
                    	    {
                    	    match('\\'); 
                    	    if ( input.LA(1)=='\"'||input.LA(1)=='\''||input.LA(1)=='\\'||input.LA(1)=='b'||input.LA(1)=='f'||input.LA(1)=='n'||input.LA(1)=='r'||(input.LA(1)>='t' && input.LA(1)<='u') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;}


                    	    }
                    	    break;
                    	case 2 :
                    	    // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:219:137: ~ ( ( '\\\\' | '\\'' ) )
                    	    {
                    	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='&')||(input.LA(1)>='(' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFF') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;}


                    	    }
                    	    break;

                    	default :
                    	    break loop7;
                        }
                    } while (true);

                    match('\''); 

                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_STRING"

    // $ANTLR start "RULE_ML_COMMENT"
    public final void mRULE_ML_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_ML_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:221:17: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:221:19: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:221:24: ( options {greedy=false; } : . )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0=='*') ) {
                    int LA9_1 = input.LA(2);

                    if ( (LA9_1=='/') ) {
                        alt9=2;
                    }
                    else if ( ((LA9_1>='\u0000' && LA9_1<='.')||(LA9_1>='0' && LA9_1<='\uFFFF')) ) {
                        alt9=1;
                    }


                }
                else if ( ((LA9_0>='\u0000' && LA9_0<=')')||(LA9_0>='+' && LA9_0<='\uFFFF')) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:221:52: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);

            match("*/"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ML_COMMENT"

    // $ANTLR start "RULE_SL_COMMENT"
    public final void mRULE_SL_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_SL_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:223:17: ( '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )? )
            // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:223:19: '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )?
            {
            match("//"); 

            // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:223:24: (~ ( ( '\\n' | '\\r' ) ) )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( ((LA10_0>='\u0000' && LA10_0<='\t')||(LA10_0>='\u000B' && LA10_0<='\f')||(LA10_0>='\u000E' && LA10_0<='\uFFFF')) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:223:24: ~ ( ( '\\n' | '\\r' ) )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);

            // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:223:40: ( ( '\\r' )? '\\n' )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0=='\n'||LA12_0=='\r') ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:223:41: ( '\\r' )? '\\n'
                    {
                    // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:223:41: ( '\\r' )?
                    int alt11=2;
                    int LA11_0 = input.LA(1);

                    if ( (LA11_0=='\r') ) {
                        alt11=1;
                    }
                    switch (alt11) {
                        case 1 :
                            // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:223:41: '\\r'
                            {
                            match('\r'); 

                            }
                            break;

                    }

                    match('\n'); 

                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_SL_COMMENT"

    // $ANTLR start "RULE_WS"
    public final void mRULE_WS() throws RecognitionException {
        try {
            int _type = RULE_WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:225:9: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:225:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:225:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            int cnt13=0;
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( ((LA13_0>='\t' && LA13_0<='\n')||LA13_0=='\r'||LA13_0==' ') ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:
            	    {
            	    if ( (input.LA(1)>='\t' && input.LA(1)<='\n')||input.LA(1)=='\r'||input.LA(1)==' ' ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    if ( cnt13 >= 1 ) break loop13;
                        EarlyExitException eee =
                            new EarlyExitException(13, input);
                        throw eee;
                }
                cnt13++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_WS"

    // $ANTLR start "RULE_ANY_OTHER"
    public final void mRULE_ANY_OTHER() throws RecognitionException {
        try {
            int _type = RULE_ANY_OTHER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:227:16: ( . )
            // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:227:18: .
            {
            matchAny(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ANY_OTHER"

    public void mTokens() throws RecognitionException {
        // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:1:8: ( KEYWORD_91 | KEYWORD_92 | KEYWORD_93 | KEYWORD_94 | KEYWORD_95 | KEYWORD_96 | KEYWORD_88 | KEYWORD_89 | KEYWORD_90 | KEYWORD_84 | KEYWORD_85 | KEYWORD_86 | KEYWORD_87 | KEYWORD_75 | KEYWORD_76 | KEYWORD_77 | KEYWORD_78 | KEYWORD_79 | KEYWORD_80 | KEYWORD_81 | KEYWORD_82 | KEYWORD_83 | KEYWORD_66 | KEYWORD_67 | KEYWORD_68 | KEYWORD_69 | KEYWORD_70 | KEYWORD_71 | KEYWORD_72 | KEYWORD_73 | KEYWORD_74 | KEYWORD_59 | KEYWORD_60 | KEYWORD_61 | KEYWORD_62 | KEYWORD_63 | KEYWORD_64 | KEYWORD_65 | KEYWORD_45 | KEYWORD_46 | KEYWORD_47 | KEYWORD_48 | KEYWORD_49 | KEYWORD_50 | KEYWORD_51 | KEYWORD_52 | KEYWORD_53 | KEYWORD_54 | KEYWORD_55 | KEYWORD_56 | KEYWORD_57 | KEYWORD_58 | KEYWORD_37 | KEYWORD_38 | KEYWORD_39 | KEYWORD_40 | KEYWORD_41 | KEYWORD_42 | KEYWORD_43 | KEYWORD_44 | KEYWORD_21 | KEYWORD_22 | KEYWORD_23 | KEYWORD_24 | KEYWORD_25 | KEYWORD_26 | KEYWORD_27 | KEYWORD_28 | KEYWORD_29 | KEYWORD_30 | KEYWORD_31 | KEYWORD_32 | KEYWORD_33 | KEYWORD_34 | KEYWORD_35 | KEYWORD_36 | KEYWORD_1 | KEYWORD_2 | KEYWORD_3 | KEYWORD_4 | KEYWORD_5 | KEYWORD_6 | KEYWORD_7 | KEYWORD_8 | KEYWORD_9 | KEYWORD_10 | KEYWORD_11 | KEYWORD_12 | KEYWORD_13 | KEYWORD_14 | KEYWORD_15 | KEYWORD_16 | KEYWORD_17 | KEYWORD_18 | KEYWORD_19 | KEYWORD_20 | RULE_FLOAT | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER )
        int alt14=104;
        alt14 = dfa14.predict(input);
        switch (alt14) {
            case 1 :
                // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:1:10: KEYWORD_91
                {
                mKEYWORD_91(); 

                }
                break;
            case 2 :
                // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:1:21: KEYWORD_92
                {
                mKEYWORD_92(); 

                }
                break;
            case 3 :
                // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:1:32: KEYWORD_93
                {
                mKEYWORD_93(); 

                }
                break;
            case 4 :
                // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:1:43: KEYWORD_94
                {
                mKEYWORD_94(); 

                }
                break;
            case 5 :
                // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:1:54: KEYWORD_95
                {
                mKEYWORD_95(); 

                }
                break;
            case 6 :
                // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:1:65: KEYWORD_96
                {
                mKEYWORD_96(); 

                }
                break;
            case 7 :
                // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:1:76: KEYWORD_88
                {
                mKEYWORD_88(); 

                }
                break;
            case 8 :
                // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:1:87: KEYWORD_89
                {
                mKEYWORD_89(); 

                }
                break;
            case 9 :
                // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:1:98: KEYWORD_90
                {
                mKEYWORD_90(); 

                }
                break;
            case 10 :
                // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:1:109: KEYWORD_84
                {
                mKEYWORD_84(); 

                }
                break;
            case 11 :
                // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:1:120: KEYWORD_85
                {
                mKEYWORD_85(); 

                }
                break;
            case 12 :
                // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:1:131: KEYWORD_86
                {
                mKEYWORD_86(); 

                }
                break;
            case 13 :
                // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:1:142: KEYWORD_87
                {
                mKEYWORD_87(); 

                }
                break;
            case 14 :
                // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:1:153: KEYWORD_75
                {
                mKEYWORD_75(); 

                }
                break;
            case 15 :
                // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:1:164: KEYWORD_76
                {
                mKEYWORD_76(); 

                }
                break;
            case 16 :
                // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:1:175: KEYWORD_77
                {
                mKEYWORD_77(); 

                }
                break;
            case 17 :
                // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:1:186: KEYWORD_78
                {
                mKEYWORD_78(); 

                }
                break;
            case 18 :
                // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:1:197: KEYWORD_79
                {
                mKEYWORD_79(); 

                }
                break;
            case 19 :
                // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:1:208: KEYWORD_80
                {
                mKEYWORD_80(); 

                }
                break;
            case 20 :
                // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:1:219: KEYWORD_81
                {
                mKEYWORD_81(); 

                }
                break;
            case 21 :
                // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:1:230: KEYWORD_82
                {
                mKEYWORD_82(); 

                }
                break;
            case 22 :
                // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:1:241: KEYWORD_83
                {
                mKEYWORD_83(); 

                }
                break;
            case 23 :
                // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:1:252: KEYWORD_66
                {
                mKEYWORD_66(); 

                }
                break;
            case 24 :
                // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:1:263: KEYWORD_67
                {
                mKEYWORD_67(); 

                }
                break;
            case 25 :
                // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:1:274: KEYWORD_68
                {
                mKEYWORD_68(); 

                }
                break;
            case 26 :
                // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:1:285: KEYWORD_69
                {
                mKEYWORD_69(); 

                }
                break;
            case 27 :
                // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:1:296: KEYWORD_70
                {
                mKEYWORD_70(); 

                }
                break;
            case 28 :
                // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:1:307: KEYWORD_71
                {
                mKEYWORD_71(); 

                }
                break;
            case 29 :
                // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:1:318: KEYWORD_72
                {
                mKEYWORD_72(); 

                }
                break;
            case 30 :
                // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:1:329: KEYWORD_73
                {
                mKEYWORD_73(); 

                }
                break;
            case 31 :
                // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:1:340: KEYWORD_74
                {
                mKEYWORD_74(); 

                }
                break;
            case 32 :
                // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:1:351: KEYWORD_59
                {
                mKEYWORD_59(); 

                }
                break;
            case 33 :
                // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:1:362: KEYWORD_60
                {
                mKEYWORD_60(); 

                }
                break;
            case 34 :
                // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:1:373: KEYWORD_61
                {
                mKEYWORD_61(); 

                }
                break;
            case 35 :
                // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:1:384: KEYWORD_62
                {
                mKEYWORD_62(); 

                }
                break;
            case 36 :
                // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:1:395: KEYWORD_63
                {
                mKEYWORD_63(); 

                }
                break;
            case 37 :
                // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:1:406: KEYWORD_64
                {
                mKEYWORD_64(); 

                }
                break;
            case 38 :
                // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:1:417: KEYWORD_65
                {
                mKEYWORD_65(); 

                }
                break;
            case 39 :
                // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:1:428: KEYWORD_45
                {
                mKEYWORD_45(); 

                }
                break;
            case 40 :
                // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:1:439: KEYWORD_46
                {
                mKEYWORD_46(); 

                }
                break;
            case 41 :
                // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:1:450: KEYWORD_47
                {
                mKEYWORD_47(); 

                }
                break;
            case 42 :
                // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:1:461: KEYWORD_48
                {
                mKEYWORD_48(); 

                }
                break;
            case 43 :
                // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:1:472: KEYWORD_49
                {
                mKEYWORD_49(); 

                }
                break;
            case 44 :
                // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:1:483: KEYWORD_50
                {
                mKEYWORD_50(); 

                }
                break;
            case 45 :
                // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:1:494: KEYWORD_51
                {
                mKEYWORD_51(); 

                }
                break;
            case 46 :
                // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:1:505: KEYWORD_52
                {
                mKEYWORD_52(); 

                }
                break;
            case 47 :
                // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:1:516: KEYWORD_53
                {
                mKEYWORD_53(); 

                }
                break;
            case 48 :
                // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:1:527: KEYWORD_54
                {
                mKEYWORD_54(); 

                }
                break;
            case 49 :
                // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:1:538: KEYWORD_55
                {
                mKEYWORD_55(); 

                }
                break;
            case 50 :
                // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:1:549: KEYWORD_56
                {
                mKEYWORD_56(); 

                }
                break;
            case 51 :
                // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:1:560: KEYWORD_57
                {
                mKEYWORD_57(); 

                }
                break;
            case 52 :
                // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:1:571: KEYWORD_58
                {
                mKEYWORD_58(); 

                }
                break;
            case 53 :
                // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:1:582: KEYWORD_37
                {
                mKEYWORD_37(); 

                }
                break;
            case 54 :
                // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:1:593: KEYWORD_38
                {
                mKEYWORD_38(); 

                }
                break;
            case 55 :
                // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:1:604: KEYWORD_39
                {
                mKEYWORD_39(); 

                }
                break;
            case 56 :
                // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:1:615: KEYWORD_40
                {
                mKEYWORD_40(); 

                }
                break;
            case 57 :
                // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:1:626: KEYWORD_41
                {
                mKEYWORD_41(); 

                }
                break;
            case 58 :
                // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:1:637: KEYWORD_42
                {
                mKEYWORD_42(); 

                }
                break;
            case 59 :
                // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:1:648: KEYWORD_43
                {
                mKEYWORD_43(); 

                }
                break;
            case 60 :
                // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:1:659: KEYWORD_44
                {
                mKEYWORD_44(); 

                }
                break;
            case 61 :
                // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:1:670: KEYWORD_21
                {
                mKEYWORD_21(); 

                }
                break;
            case 62 :
                // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:1:681: KEYWORD_22
                {
                mKEYWORD_22(); 

                }
                break;
            case 63 :
                // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:1:692: KEYWORD_23
                {
                mKEYWORD_23(); 

                }
                break;
            case 64 :
                // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:1:703: KEYWORD_24
                {
                mKEYWORD_24(); 

                }
                break;
            case 65 :
                // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:1:714: KEYWORD_25
                {
                mKEYWORD_25(); 

                }
                break;
            case 66 :
                // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:1:725: KEYWORD_26
                {
                mKEYWORD_26(); 

                }
                break;
            case 67 :
                // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:1:736: KEYWORD_27
                {
                mKEYWORD_27(); 

                }
                break;
            case 68 :
                // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:1:747: KEYWORD_28
                {
                mKEYWORD_28(); 

                }
                break;
            case 69 :
                // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:1:758: KEYWORD_29
                {
                mKEYWORD_29(); 

                }
                break;
            case 70 :
                // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:1:769: KEYWORD_30
                {
                mKEYWORD_30(); 

                }
                break;
            case 71 :
                // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:1:780: KEYWORD_31
                {
                mKEYWORD_31(); 

                }
                break;
            case 72 :
                // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:1:791: KEYWORD_32
                {
                mKEYWORD_32(); 

                }
                break;
            case 73 :
                // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:1:802: KEYWORD_33
                {
                mKEYWORD_33(); 

                }
                break;
            case 74 :
                // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:1:813: KEYWORD_34
                {
                mKEYWORD_34(); 

                }
                break;
            case 75 :
                // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:1:824: KEYWORD_35
                {
                mKEYWORD_35(); 

                }
                break;
            case 76 :
                // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:1:835: KEYWORD_36
                {
                mKEYWORD_36(); 

                }
                break;
            case 77 :
                // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:1:846: KEYWORD_1
                {
                mKEYWORD_1(); 

                }
                break;
            case 78 :
                // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:1:856: KEYWORD_2
                {
                mKEYWORD_2(); 

                }
                break;
            case 79 :
                // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:1:866: KEYWORD_3
                {
                mKEYWORD_3(); 

                }
                break;
            case 80 :
                // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:1:876: KEYWORD_4
                {
                mKEYWORD_4(); 

                }
                break;
            case 81 :
                // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:1:886: KEYWORD_5
                {
                mKEYWORD_5(); 

                }
                break;
            case 82 :
                // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:1:896: KEYWORD_6
                {
                mKEYWORD_6(); 

                }
                break;
            case 83 :
                // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:1:906: KEYWORD_7
                {
                mKEYWORD_7(); 

                }
                break;
            case 84 :
                // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:1:916: KEYWORD_8
                {
                mKEYWORD_8(); 

                }
                break;
            case 85 :
                // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:1:926: KEYWORD_9
                {
                mKEYWORD_9(); 

                }
                break;
            case 86 :
                // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:1:936: KEYWORD_10
                {
                mKEYWORD_10(); 

                }
                break;
            case 87 :
                // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:1:947: KEYWORD_11
                {
                mKEYWORD_11(); 

                }
                break;
            case 88 :
                // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:1:958: KEYWORD_12
                {
                mKEYWORD_12(); 

                }
                break;
            case 89 :
                // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:1:969: KEYWORD_13
                {
                mKEYWORD_13(); 

                }
                break;
            case 90 :
                // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:1:980: KEYWORD_14
                {
                mKEYWORD_14(); 

                }
                break;
            case 91 :
                // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:1:991: KEYWORD_15
                {
                mKEYWORD_15(); 

                }
                break;
            case 92 :
                // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:1:1002: KEYWORD_16
                {
                mKEYWORD_16(); 

                }
                break;
            case 93 :
                // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:1:1013: KEYWORD_17
                {
                mKEYWORD_17(); 

                }
                break;
            case 94 :
                // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:1:1024: KEYWORD_18
                {
                mKEYWORD_18(); 

                }
                break;
            case 95 :
                // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:1:1035: KEYWORD_19
                {
                mKEYWORD_19(); 

                }
                break;
            case 96 :
                // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:1:1046: KEYWORD_20
                {
                mKEYWORD_20(); 

                }
                break;
            case 97 :
                // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:1:1057: RULE_FLOAT
                {
                mRULE_FLOAT(); 

                }
                break;
            case 98 :
                // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:1:1068: RULE_ID
                {
                mRULE_ID(); 

                }
                break;
            case 99 :
                // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:1:1076: RULE_INT
                {
                mRULE_INT(); 

                }
                break;
            case 100 :
                // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:1:1085: RULE_STRING
                {
                mRULE_STRING(); 

                }
                break;
            case 101 :
                // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:1:1097: RULE_ML_COMMENT
                {
                mRULE_ML_COMMENT(); 

                }
                break;
            case 102 :
                // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:1:1113: RULE_SL_COMMENT
                {
                mRULE_SL_COMMENT(); 

                }
                break;
            case 103 :
                // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:1:1129: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 104 :
                // ../de.jevopi.mitra2/src-gen/de/jevopi/mitra2/parser/antlr/lexer/InternalMitraLexer.g:1:1137: RULE_ANY_OTHER
                {
                mRULE_ANY_OTHER(); 

                }
                break;

        }

    }


    protected DFA14 dfa14 = new DFA14(this);
    static final String DFA14_eotS =
        "\1\uffff\27\64\1\145\1\147\1\152\1\156\1\160\1\163\1\165\1\170\1"+
        "\172\5\uffff\1\u0080\1\u0084\4\uffff\1\u0089\1\62\1\uffff\2\62\2"+
        "\uffff\1\64\1\uffff\10\64\1\u0098\22\64\1\u00b1\23\64\46\uffff\1"+
        "\u0089\2\uffff\3\64\1\u00cc\6\64\1\u00d5\1\uffff\12\64\1\u00e0\15"+
        "\64\1\uffff\3\64\1\u00f1\6\64\1\u00f8\11\64\1\u0102\1\u0103\1\u0104"+
        "\3\64\1\uffff\1\64\1\u0109\1\64\1\u010b\3\64\1\u010f\1\uffff\12"+
        "\64\1\uffff\4\64\1\u011e\1\u011f\11\64\1\u0129\1\uffff\2\64\1\u012c"+
        "\2\64\1\u012f\1\uffff\2\64\1\u0132\1\64\1\u0134\1\u0135\1\u0136"+
        "\1\u0137\1\u0138\3\uffff\4\64\1\uffff\1\64\1\uffff\3\64\1\uffff"+
        "\3\64\1\u0144\12\64\2\uffff\1\64\1\u0150\2\64\1\u0153\3\64\1\u0157"+
        "\1\uffff\1\64\1\u0159\1\uffff\2\64\1\uffff\1\u015c\1\64\1\uffff"+
        "\1\u015e\5\uffff\6\64\1\u0165\2\64\1\u0168\1\u0169\1\uffff\4\64"+
        "\1\u016e\1\64\1\u0170\2\64\1\u0173\1\64\1\uffff\1\64\1\u0176\1\uffff"+
        "\1\u0177\2\64\1\uffff\1\64\1\uffff\1\64\1\u017c\1\uffff\1\64\1\uffff"+
        "\6\64\1\uffff\2\64\2\uffff\2\64\1\u0188\1\u0189\1\uffff\1\64\1\uffff"+
        "\2\64\1\uffff\1\u018d\1\u018e\2\uffff\1\u018f\1\u0190\1\u0191\1"+
        "\u0192\1\uffff\1\u0193\3\64\1\u0197\6\64\2\uffff\1\u019e\1\u019f"+
        "\1\u01a0\7\uffff\3\64\1\uffff\3\64\1\u01a7\1\u01a8\1\u01a9\3\uffff"+
        "\1\u01aa\1\u01ab\1\u01ac\1\u01ad\1\u01ae\1\u01af\11\uffff";
    static final String DFA14_eofS =
        "\u01b0\uffff";
    static final String DFA14_minS =
        "\1\0\1\157\1\162\1\142\1\154\1\146\1\141\1\166\1\141\2\145\1\157"+
        "\1\141\1\145\1\141\1\145\1\150\1\151\1\150\1\171\1\141\1\145\1\141"+
        "\1\163\1\75\1\46\1\53\1\55\1\72\1\74\2\75\1\174\5\uffff\1\60\1\52"+
        "\4\uffff\1\56\1\101\1\uffff\2\0\2\uffff\1\154\1\uffff\1\144\1\156"+
        "\1\163\1\164\1\143\1\163\1\160\1\163\1\60\1\164\1\156\1\144\1\154"+
        "\1\145\1\143\1\151\1\142\1\161\1\162\1\141\1\154\1\157\1\145\1\156"+
        "\1\154\1\145\1\146\1\60\1\156\1\154\1\157\1\162\1\145\1\160\1\154"+
        "\1\141\2\162\1\151\1\145\1\164\1\160\1\166\1\154\1\167\1\147\1\145"+
        "\46\uffff\1\56\2\uffff\1\154\1\145\1\157\1\60\1\164\1\157\1\154"+
        "\1\145\1\154\1\164\1\60\1\uffff\1\141\2\165\1\164\1\162\1\141\1"+
        "\153\1\166\1\154\1\165\1\60\1\151\1\154\2\165\1\154\1\145\1\154"+
        "\1\141\1\146\1\154\1\143\2\141\1\uffff\1\141\1\163\1\155\1\60\1"+
        "\141\1\145\1\146\1\147\1\143\1\145\1\60\1\157\1\164\1\144\1\154"+
        "\1\156\1\150\1\145\1\141\1\154\3\60\1\145\1\162\1\164\1\uffff\1"+
        "\162\1\60\1\165\1\60\1\145\1\162\1\141\1\60\1\uffff\1\155\1\141"+
        "\1\154\1\151\1\162\1\155\2\141\1\151\1\145\1\uffff\1\156\1\141\1"+
        "\151\1\162\2\60\1\145\1\153\1\151\1\145\1\150\1\164\1\165\1\154"+
        "\1\145\1\60\1\uffff\1\154\1\162\1\60\1\147\1\145\1\60\1\uffff\1"+
        "\167\1\165\1\60\1\145\5\60\3\uffff\1\143\1\145\2\141\1\uffff\1\144"+
        "\1\uffff\1\155\1\164\1\156\1\uffff\1\157\1\154\1\145\1\60\1\151"+
        "\1\145\1\147\1\164\1\143\1\156\1\147\1\143\1\162\1\156\2\uffff\1"+
        "\141\1\60\1\162\1\144\1\60\1\145\2\154\1\60\1\uffff\1\164\1\60\1"+
        "\uffff\1\145\1\144\1\uffff\1\60\1\141\1\uffff\1\60\5\uffff\1\164"+
        "\1\144\1\164\1\143\2\145\1\60\1\143\1\144\2\60\1\uffff\1\144\1\164"+
        "\2\145\1\60\1\143\1\60\2\145\1\60\1\156\1\uffff\1\155\1\60\1\uffff"+
        "\1\60\1\164\1\171\1\uffff\1\150\1\uffff\1\162\1\60\1\uffff\1\154"+
        "\1\uffff\1\151\1\123\1\151\1\164\1\144\1\156\1\uffff\2\145\2\uffff"+
        "\2\145\2\60\1\uffff\1\145\1\uffff\1\163\1\144\1\uffff\2\60\2\uffff"+
        "\4\60\1\uffff\1\60\1\157\1\145\1\157\1\60\1\102\1\164\1\157\1\154"+
        "\1\163\1\162\2\uffff\3\60\7\uffff\1\156\1\164\1\156\1\uffff\1\171"+
        "\1\163\1\146\3\60\3\uffff\6\60\11\uffff";
    static final String DFA14_maxS =
        "\1\uffff\1\157\1\162\1\165\1\170\1\156\1\165\1\166\1\165\1\164\1"+
        "\165\2\162\1\157\1\162\1\165\1\162\1\157\1\151\1\171\1\141\1\165"+
        "\1\141\1\163\1\75\1\46\1\75\1\76\1\72\2\75\1\76\1\174\5\uffff\1"+
        "\71\1\57\4\uffff\1\71\1\172\1\uffff\2\uffff\2\uffff\1\154\1\uffff"+
        "\1\144\1\171\1\163\1\164\1\143\1\163\1\160\1\164\1\172\1\164\1\156"+
        "\1\144\1\154\1\145\1\162\1\151\1\142\1\164\1\162\1\164\1\154\1\157"+
        "\1\145\1\156\1\164\1\145\1\146\1\172\1\156\1\154\1\157\1\162\1\145"+
        "\1\160\1\154\1\171\2\162\2\151\1\164\1\160\1\166\1\154\1\167\1\147"+
        "\1\145\46\uffff\1\71\2\uffff\1\154\1\145\1\157\1\172\1\164\1\157"+
        "\1\154\1\145\1\157\1\164\1\172\1\uffff\1\141\2\165\1\164\1\162\1"+
        "\141\1\153\1\166\1\154\1\165\1\172\1\151\1\154\2\165\1\154\1\145"+
        "\1\154\1\141\1\146\1\154\1\143\2\141\1\uffff\1\141\1\163\1\155\1"+
        "\172\1\141\1\145\1\146\1\147\1\143\1\145\1\172\1\157\1\164\1\144"+
        "\1\154\1\156\1\150\1\145\1\141\1\154\3\172\1\145\1\162\1\164\1\uffff"+
        "\1\162\1\172\1\165\1\172\1\145\1\162\1\141\1\172\1\uffff\1\155\1"+
        "\141\1\154\1\151\1\162\1\155\2\141\1\151\1\145\1\uffff\1\156\1\141"+
        "\1\151\1\162\2\172\1\145\1\153\1\151\1\145\1\150\1\164\1\165\1\154"+
        "\1\145\1\172\1\uffff\1\154\1\162\1\172\1\147\1\145\1\172\1\uffff"+
        "\1\167\1\165\1\172\1\145\5\172\3\uffff\1\143\1\145\2\141\1\uffff"+
        "\1\144\1\uffff\1\155\1\164\1\156\1\uffff\1\157\1\154\1\145\1\172"+
        "\1\151\1\145\1\147\1\164\1\143\1\156\1\147\1\143\1\162\1\156\2\uffff"+
        "\1\141\1\172\1\162\1\144\1\172\1\145\2\154\1\172\1\uffff\1\164\1"+
        "\172\1\uffff\1\145\1\144\1\uffff\1\172\1\141\1\uffff\1\172\5\uffff"+
        "\1\164\1\144\1\164\1\143\2\145\1\172\1\143\1\144\2\172\1\uffff\1"+
        "\144\1\164\2\145\1\172\1\143\1\172\2\145\1\172\1\156\1\uffff\1\155"+
        "\1\172\1\uffff\1\172\1\164\1\171\1\uffff\1\150\1\uffff\1\162\1\172"+
        "\1\uffff\1\154\1\uffff\1\151\1\123\1\151\1\164\1\144\1\156\1\uffff"+
        "\2\145\2\uffff\2\145\2\172\1\uffff\1\145\1\uffff\1\163\1\144\1\uffff"+
        "\2\172\2\uffff\4\172\1\uffff\1\172\1\157\1\145\1\157\1\172\1\102"+
        "\1\164\1\157\1\154\1\163\1\162\2\uffff\3\172\7\uffff\1\156\1\164"+
        "\1\156\1\uffff\1\171\1\163\1\146\3\172\3\uffff\6\172\11\uffff";
    static final String DFA14_acceptS =
        "\41\uffff\1\116\1\120\1\121\1\122\1\124\2\uffff\1\131\1\135\1\136"+
        "\1\140\2\uffff\1\142\2\uffff\1\147\1\150\1\uffff\1\142\57\uffff"+
        "\1\75\1\115\1\76\1\117\1\77\1\100\1\123\1\101\1\102\1\103\1\125"+
        "\1\104\1\130\1\105\1\106\1\132\1\107\1\133\1\110\1\111\1\134\1\114"+
        "\1\137\1\116\1\120\1\121\1\122\1\124\1\126\1\141\1\145\1\146\1\127"+
        "\1\131\1\135\1\136\1\140\1\143\1\uffff\1\144\1\147\13\uffff\1\113"+
        "\30\uffff\1\112\32\uffff\1\67\10\uffff\1\71\12\uffff\1\66\20\uffff"+
        "\1\70\6\uffff\1\73\11\uffff\1\72\1\65\1\74\4\uffff\1\50\1\uffff"+
        "\1\51\3\uffff\1\53\16\uffff\1\56\1\57\11\uffff\1\52\2\uffff\1\60"+
        "\2\uffff\1\61\2\uffff\1\62\1\uffff\1\63\1\64\1\47\1\54\1\55\13\uffff"+
        "\1\43\13\uffff\1\40\2\uffff\1\41\3\uffff\1\42\1\uffff\1\44\2\uffff"+
        "\1\45\1\uffff\1\46\6\uffff\1\32\2\uffff\1\33\1\34\4\uffff\1\35\1"+
        "\uffff\1\27\2\uffff\1\36\2\uffff\1\30\1\31\4\uffff\1\37\13\uffff"+
        "\1\22\1\23\3\uffff\1\16\1\17\1\20\1\21\1\24\1\25\1\26\3\uffff\1"+
        "\13\6\uffff\1\12\1\14\1\15\6\uffff\1\7\1\10\1\11\1\1\1\2\1\3\1\4"+
        "\1\5\1\6";
    static final String DFA14_specialS =
        "\1\0\56\uffff\1\2\1\1\u017f\uffff}>";
    static final String[] DFA14_transitionS = {
            "\11\62\2\61\2\62\1\61\22\62\1\61\1\30\1\57\1\62\1\41\1\62\1"+
            "\31\1\60\1\42\1\43\1\44\1\32\1\45\1\33\1\46\1\47\12\54\1\34"+
            "\1\50\1\35\1\36\1\37\1\62\1\51\1\56\1\26\1\1\13\56\1\2\3\56"+
            "\1\11\1\23\6\56\3\62\1\55\1\56\1\62\1\3\1\13\1\14\1\15\1\4\1"+
            "\16\2\56\1\5\1\24\2\56\1\6\1\25\1\7\1\10\1\56\1\12\1\17\1\20"+
            "\1\27\1\21\1\22\3\56\1\52\1\40\1\53\uff82\62",
            "\1\63",
            "\1\65",
            "\1\67\13\uffff\1\66\6\uffff\1\70",
            "\1\72\13\uffff\1\71",
            "\1\75\6\uffff\1\73\1\74",
            "\1\77\3\uffff\1\76\11\uffff\1\100\5\uffff\1\101",
            "\1\102",
            "\1\103\20\uffff\1\104\2\uffff\1\105",
            "\1\106\16\uffff\1\107",
            "\1\110\17\uffff\1\111",
            "\1\112\2\uffff\1\113",
            "\1\115\15\uffff\1\114\2\uffff\1\116",
            "\1\117\11\uffff\1\120",
            "\1\122\7\uffff\1\121\5\uffff\1\124\2\uffff\1\123",
            "\1\127\16\uffff\1\125\1\126",
            "\1\131\11\uffff\1\130",
            "\1\132\5\uffff\1\133",
            "\1\134\1\135",
            "\1\136",
            "\1\137",
            "\1\141\17\uffff\1\140",
            "\1\142",
            "\1\143",
            "\1\144",
            "\1\146",
            "\1\150\21\uffff\1\151",
            "\1\153\17\uffff\1\154\1\155",
            "\1\157",
            "\1\161\1\162",
            "\1\164",
            "\1\166\1\167",
            "\1\171",
            "",
            "",
            "",
            "",
            "",
            "\12\u0081",
            "\1\u0082\4\uffff\1\u0083",
            "",
            "",
            "",
            "",
            "\1\u0081\1\uffff\12\u008a",
            "\32\64\4\uffff\1\64\1\uffff\32\64",
            "",
            "\0\u008b",
            "\0\u008b",
            "",
            "",
            "\1\u008d",
            "",
            "\1\u008e",
            "\1\u008f\12\uffff\1\u0090",
            "\1\u0091",
            "\1\u0092",
            "\1\u0093",
            "\1\u0094",
            "\1\u0095",
            "\1\u0096\1\u0097",
            "\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
            "\1\u0099",
            "\1\u009a",
            "\1\u009b",
            "\1\u009c",
            "\1\u009d",
            "\1\u009f\16\uffff\1\u009e",
            "\1\u00a0",
            "\1\u00a1",
            "\1\u00a2\2\uffff\1\u00a3",
            "\1\u00a4",
            "\1\u00a8\16\uffff\1\u00a5\1\u00a6\2\uffff\1\u00a7",
            "\1\u00a9",
            "\1\u00aa",
            "\1\u00ab",
            "\1\u00ac",
            "\1\u00ad\7\uffff\1\u00ae",
            "\1\u00af",
            "\1\u00b0",
            "\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
            "\1\u00b2",
            "\1\u00b3",
            "\1\u00b4",
            "\1\u00b5",
            "\1\u00b6",
            "\1\u00b7",
            "\1\u00b8",
            "\1\u00ba\7\uffff\1\u00b9\13\uffff\1\u00bb\3\uffff\1\u00bc",
            "\1\u00bd",
            "\1\u00be",
            "\1\u00bf",
            "\1\u00c1\3\uffff\1\u00c0",
            "\1\u00c2",
            "\1\u00c3",
            "\1\u00c4",
            "\1\u00c5",
            "\1\u00c6",
            "\1\u00c7",
            "\1\u00c8",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\u0081\1\uffff\12\u008a",
            "",
            "",
            "\1\u00c9",
            "\1\u00ca",
            "\1\u00cb",
            "\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
            "\1\u00cd",
            "\1\u00ce",
            "\1\u00cf",
            "\1\u00d0",
            "\1\u00d1\2\uffff\1\u00d2",
            "\1\u00d3",
            "\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\16\64\1\u00d4\13"+
            "\64",
            "",
            "\1\u00d6",
            "\1\u00d7",
            "\1\u00d8",
            "\1\u00d9",
            "\1\u00da",
            "\1\u00db",
            "\1\u00dc",
            "\1\u00dd",
            "\1\u00de",
            "\1\u00df",
            "\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
            "\1\u00e1",
            "\1\u00e2",
            "\1\u00e3",
            "\1\u00e4",
            "\1\u00e5",
            "\1\u00e6",
            "\1\u00e7",
            "\1\u00e8",
            "\1\u00e9",
            "\1\u00ea",
            "\1\u00eb",
            "\1\u00ec",
            "\1\u00ed",
            "",
            "\1\u00ee",
            "\1\u00ef",
            "\1\u00f0",
            "\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
            "\1\u00f2",
            "\1\u00f3",
            "\1\u00f4",
            "\1\u00f5",
            "\1\u00f6",
            "\1\u00f7",
            "\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
            "\1\u00f9",
            "\1\u00fa",
            "\1\u00fb",
            "\1\u00fc",
            "\1\u00fd",
            "\1\u00fe",
            "\1\u00ff",
            "\1\u0100",
            "\1\u0101",
            "\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
            "\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
            "\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
            "\1\u0105",
            "\1\u0106",
            "\1\u0107",
            "",
            "\1\u0108",
            "\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
            "\1\u010a",
            "\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
            "\1\u010c",
            "\1\u010d",
            "\1\u010e",
            "\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
            "",
            "\1\u0110",
            "\1\u0111",
            "\1\u0112",
            "\1\u0113",
            "\1\u0114",
            "\1\u0115",
            "\1\u0116",
            "\1\u0117",
            "\1\u0118",
            "\1\u0119",
            "",
            "\1\u011a",
            "\1\u011b",
            "\1\u011c",
            "\1\u011d",
            "\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
            "\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
            "\1\u0120",
            "\1\u0121",
            "\1\u0122",
            "\1\u0123",
            "\1\u0124",
            "\1\u0125",
            "\1\u0126",
            "\1\u0127",
            "\1\u0128",
            "\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
            "",
            "\1\u012a",
            "\1\u012b",
            "\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
            "\1\u012d",
            "\1\u012e",
            "\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
            "",
            "\1\u0130",
            "\1\u0131",
            "\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
            "\1\u0133",
            "\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
            "\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
            "\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
            "\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
            "\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
            "",
            "",
            "",
            "\1\u0139",
            "\1\u013a",
            "\1\u013b",
            "\1\u013c",
            "",
            "\1\u013d",
            "",
            "\1\u013e",
            "\1\u013f",
            "\1\u0140",
            "",
            "\1\u0141",
            "\1\u0142",
            "\1\u0143",
            "\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
            "\1\u0145",
            "\1\u0146",
            "\1\u0147",
            "\1\u0148",
            "\1\u0149",
            "\1\u014a",
            "\1\u014b",
            "\1\u014c",
            "\1\u014d",
            "\1\u014e",
            "",
            "",
            "\1\u014f",
            "\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
            "\1\u0151",
            "\1\u0152",
            "\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
            "\1\u0154",
            "\1\u0155",
            "\1\u0156",
            "\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
            "",
            "\1\u0158",
            "\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
            "",
            "\1\u015a",
            "\1\u015b",
            "",
            "\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
            "\1\u015d",
            "",
            "\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
            "",
            "",
            "",
            "",
            "",
            "\1\u015f",
            "\1\u0160",
            "\1\u0161",
            "\1\u0162",
            "\1\u0163",
            "\1\u0164",
            "\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
            "\1\u0166",
            "\1\u0167",
            "\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
            "\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
            "",
            "\1\u016a",
            "\1\u016b",
            "\1\u016c",
            "\1\u016d",
            "\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
            "\1\u016f",
            "\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
            "\1\u0171",
            "\1\u0172",
            "\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
            "\1\u0174",
            "",
            "\1\u0175",
            "\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
            "",
            "\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
            "\1\u0178",
            "\1\u0179",
            "",
            "\1\u017a",
            "",
            "\1\u017b",
            "\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
            "",
            "\1\u017d",
            "",
            "\1\u017e",
            "\1\u017f",
            "\1\u0180",
            "\1\u0181",
            "\1\u0182",
            "\1\u0183",
            "",
            "\1\u0184",
            "\1\u0185",
            "",
            "",
            "\1\u0186",
            "\1\u0187",
            "\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
            "\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
            "",
            "\1\u018a",
            "",
            "\1\u018b",
            "\1\u018c",
            "",
            "\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
            "\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
            "",
            "",
            "\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
            "\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
            "\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
            "\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
            "",
            "\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
            "\1\u0194",
            "\1\u0195",
            "\1\u0196",
            "\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
            "\1\u0198",
            "\1\u0199",
            "\1\u019a",
            "\1\u019b",
            "\1\u019c",
            "\1\u019d",
            "",
            "",
            "\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
            "\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
            "\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\u01a1",
            "\1\u01a2",
            "\1\u01a3",
            "",
            "\1\u01a4",
            "\1\u01a5",
            "\1\u01a6",
            "\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
            "\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
            "\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
            "",
            "",
            "",
            "\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
            "\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
            "\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
            "\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
            "\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
            "\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA14_eot = DFA.unpackEncodedString(DFA14_eotS);
    static final short[] DFA14_eof = DFA.unpackEncodedString(DFA14_eofS);
    static final char[] DFA14_min = DFA.unpackEncodedStringToUnsignedChars(DFA14_minS);
    static final char[] DFA14_max = DFA.unpackEncodedStringToUnsignedChars(DFA14_maxS);
    static final short[] DFA14_accept = DFA.unpackEncodedString(DFA14_acceptS);
    static final short[] DFA14_special = DFA.unpackEncodedString(DFA14_specialS);
    static final short[][] DFA14_transition;

    static {
        int numStates = DFA14_transitionS.length;
        DFA14_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA14_transition[i] = DFA.unpackEncodedString(DFA14_transitionS[i]);
        }
    }

    class DFA14 extends DFA {

        public DFA14(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 14;
            this.eot = DFA14_eot;
            this.eof = DFA14_eof;
            this.min = DFA14_min;
            this.max = DFA14_max;
            this.accept = DFA14_accept;
            this.special = DFA14_special;
            this.transition = DFA14_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( KEYWORD_91 | KEYWORD_92 | KEYWORD_93 | KEYWORD_94 | KEYWORD_95 | KEYWORD_96 | KEYWORD_88 | KEYWORD_89 | KEYWORD_90 | KEYWORD_84 | KEYWORD_85 | KEYWORD_86 | KEYWORD_87 | KEYWORD_75 | KEYWORD_76 | KEYWORD_77 | KEYWORD_78 | KEYWORD_79 | KEYWORD_80 | KEYWORD_81 | KEYWORD_82 | KEYWORD_83 | KEYWORD_66 | KEYWORD_67 | KEYWORD_68 | KEYWORD_69 | KEYWORD_70 | KEYWORD_71 | KEYWORD_72 | KEYWORD_73 | KEYWORD_74 | KEYWORD_59 | KEYWORD_60 | KEYWORD_61 | KEYWORD_62 | KEYWORD_63 | KEYWORD_64 | KEYWORD_65 | KEYWORD_45 | KEYWORD_46 | KEYWORD_47 | KEYWORD_48 | KEYWORD_49 | KEYWORD_50 | KEYWORD_51 | KEYWORD_52 | KEYWORD_53 | KEYWORD_54 | KEYWORD_55 | KEYWORD_56 | KEYWORD_57 | KEYWORD_58 | KEYWORD_37 | KEYWORD_38 | KEYWORD_39 | KEYWORD_40 | KEYWORD_41 | KEYWORD_42 | KEYWORD_43 | KEYWORD_44 | KEYWORD_21 | KEYWORD_22 | KEYWORD_23 | KEYWORD_24 | KEYWORD_25 | KEYWORD_26 | KEYWORD_27 | KEYWORD_28 | KEYWORD_29 | KEYWORD_30 | KEYWORD_31 | KEYWORD_32 | KEYWORD_33 | KEYWORD_34 | KEYWORD_35 | KEYWORD_36 | KEYWORD_1 | KEYWORD_2 | KEYWORD_3 | KEYWORD_4 | KEYWORD_5 | KEYWORD_6 | KEYWORD_7 | KEYWORD_8 | KEYWORD_9 | KEYWORD_10 | KEYWORD_11 | KEYWORD_12 | KEYWORD_13 | KEYWORD_14 | KEYWORD_15 | KEYWORD_16 | KEYWORD_17 | KEYWORD_18 | KEYWORD_19 | KEYWORD_20 | RULE_FLOAT | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA14_0 = input.LA(1);

                        s = -1;
                        if ( (LA14_0=='C') ) {s = 1;}

                        else if ( (LA14_0=='O') ) {s = 2;}

                        else if ( (LA14_0=='a') ) {s = 3;}

                        else if ( (LA14_0=='e') ) {s = 4;}

                        else if ( (LA14_0=='i') ) {s = 5;}

                        else if ( (LA14_0=='m') ) {s = 6;}

                        else if ( (LA14_0=='o') ) {s = 7;}

                        else if ( (LA14_0=='p') ) {s = 8;}

                        else if ( (LA14_0=='S') ) {s = 9;}

                        else if ( (LA14_0=='r') ) {s = 10;}

                        else if ( (LA14_0=='b') ) {s = 11;}

                        else if ( (LA14_0=='c') ) {s = 12;}

                        else if ( (LA14_0=='d') ) {s = 13;}

                        else if ( (LA14_0=='f') ) {s = 14;}

                        else if ( (LA14_0=='s') ) {s = 15;}

                        else if ( (LA14_0=='t') ) {s = 16;}

                        else if ( (LA14_0=='v') ) {s = 17;}

                        else if ( (LA14_0=='w') ) {s = 18;}

                        else if ( (LA14_0=='T') ) {s = 19;}

                        else if ( (LA14_0=='j') ) {s = 20;}

                        else if ( (LA14_0=='n') ) {s = 21;}

                        else if ( (LA14_0=='B') ) {s = 22;}

                        else if ( (LA14_0=='u') ) {s = 23;}

                        else if ( (LA14_0=='!') ) {s = 24;}

                        else if ( (LA14_0=='&') ) {s = 25;}

                        else if ( (LA14_0=='+') ) {s = 26;}

                        else if ( (LA14_0=='-') ) {s = 27;}

                        else if ( (LA14_0==':') ) {s = 28;}

                        else if ( (LA14_0=='<') ) {s = 29;}

                        else if ( (LA14_0=='=') ) {s = 30;}

                        else if ( (LA14_0=='>') ) {s = 31;}

                        else if ( (LA14_0=='|') ) {s = 32;}

                        else if ( (LA14_0=='$') ) {s = 33;}

                        else if ( (LA14_0=='(') ) {s = 34;}

                        else if ( (LA14_0==')') ) {s = 35;}

                        else if ( (LA14_0=='*') ) {s = 36;}

                        else if ( (LA14_0==',') ) {s = 37;}

                        else if ( (LA14_0=='.') ) {s = 38;}

                        else if ( (LA14_0=='/') ) {s = 39;}

                        else if ( (LA14_0==';') ) {s = 40;}

                        else if ( (LA14_0=='@') ) {s = 41;}

                        else if ( (LA14_0=='{') ) {s = 42;}

                        else if ( (LA14_0=='}') ) {s = 43;}

                        else if ( ((LA14_0>='0' && LA14_0<='9')) ) {s = 44;}

                        else if ( (LA14_0=='^') ) {s = 45;}

                        else if ( (LA14_0=='A'||(LA14_0>='D' && LA14_0<='N')||(LA14_0>='P' && LA14_0<='R')||(LA14_0>='U' && LA14_0<='Z')||LA14_0=='_'||(LA14_0>='g' && LA14_0<='h')||(LA14_0>='k' && LA14_0<='l')||LA14_0=='q'||(LA14_0>='x' && LA14_0<='z')) ) {s = 46;}

                        else if ( (LA14_0=='\"') ) {s = 47;}

                        else if ( (LA14_0=='\'') ) {s = 48;}

                        else if ( ((LA14_0>='\t' && LA14_0<='\n')||LA14_0=='\r'||LA14_0==' ') ) {s = 49;}

                        else if ( ((LA14_0>='\u0000' && LA14_0<='\b')||(LA14_0>='\u000B' && LA14_0<='\f')||(LA14_0>='\u000E' && LA14_0<='\u001F')||LA14_0=='#'||LA14_0=='%'||LA14_0=='?'||(LA14_0>='[' && LA14_0<=']')||LA14_0=='`'||(LA14_0>='~' && LA14_0<='\uFFFF')) ) {s = 50;}

                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA14_48 = input.LA(1);

                        s = -1;
                        if ( ((LA14_48>='\u0000' && LA14_48<='\uFFFF')) ) {s = 139;}

                        else s = 50;

                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA14_47 = input.LA(1);

                        s = -1;
                        if ( ((LA14_47>='\u0000' && LA14_47<='\uFFFF')) ) {s = 139;}

                        else s = 50;

                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 14, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

}