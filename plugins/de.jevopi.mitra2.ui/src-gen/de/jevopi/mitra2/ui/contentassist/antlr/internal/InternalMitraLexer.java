package de.jevopi.mitra2.ui.contentassist.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalMitraLexer extends Lexer {
    public static final int RULE_ID=4;
    public static final int T__29=29;
    public static final int T__28=28;
    public static final int T__27=27;
    public static final int T__26=26;
    public static final int T__25=25;
    public static final int T__24=24;
    public static final int T__23=23;
    public static final int T__22=22;
    public static final int RULE_ANY_OTHER=11;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int EOF=-1;
    public static final int T__93=93;
    public static final int T__19=19;
    public static final int T__94=94;
    public static final int T__91=91;
    public static final int T__92=92;
    public static final int T__16=16;
    public static final int T__90=90;
    public static final int T__15=15;
    public static final int T__18=18;
    public static final int T__17=17;
    public static final int T__12=12;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int T__99=99;
    public static final int T__98=98;
    public static final int T__97=97;
    public static final int T__96=96;
    public static final int T__95=95;
    public static final int T__80=80;
    public static final int T__81=81;
    public static final int T__82=82;
    public static final int T__83=83;
    public static final int T__85=85;
    public static final int T__84=84;
    public static final int T__87=87;
    public static final int T__86=86;
    public static final int T__89=89;
    public static final int T__88=88;
    public static final int RULE_ML_COMMENT=8;
    public static final int RULE_STRING=5;
    public static final int T__71=71;
    public static final int T__72=72;
    public static final int T__70=70;
    public static final int T__76=76;
    public static final int T__75=75;
    public static final int T__74=74;
    public static final int T__73=73;
    public static final int T__79=79;
    public static final int T__78=78;
    public static final int T__77=77;
    public static final int T__68=68;
    public static final int T__69=69;
    public static final int T__66=66;
    public static final int T__67=67;
    public static final int T__64=64;
    public static final int T__65=65;
    public static final int T__62=62;
    public static final int T__63=63;
    public static final int T__61=61;
    public static final int T__60=60;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int T__57=57;
    public static final int T__58=58;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int T__107=107;
    public static final int T__103=103;
    public static final int T__59=59;
    public static final int T__104=104;
    public static final int T__105=105;
    public static final int T__106=106;
    public static final int RULE_INT=6;
    public static final int T__50=50;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int T__102=102;
    public static final int T__101=101;
    public static final int T__100=100;
    public static final int RULE_FLOAT=7;
    public static final int RULE_SL_COMMENT=9;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int RULE_WS=10;

    // delegates
    // delegators

    public InternalMitraLexer() {;} 
    public InternalMitraLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public InternalMitraLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g"; }

    // $ANTLR start "T__12"
    public final void mT__12() throws RecognitionException {
        try {
            int _type = T__12;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:11:7: ( ';' )
            // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:11:9: ';'
            {
            match(';'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__12"

    // $ANTLR start "T__13"
    public final void mT__13() throws RecognitionException {
        try {
            int _type = T__13;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:12:7: ( 'false' )
            // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:12:9: 'false'
            {
            match("false"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__13"

    // $ANTLR start "T__14"
    public final void mT__14() throws RecognitionException {
        try {
            int _type = T__14;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:13:7: ( 'public' )
            // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:13:9: 'public'
            {
            match("public"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__14"

    // $ANTLR start "T__15"
    public final void mT__15() throws RecognitionException {
        try {
            int _type = T__15;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:14:7: ( 'private' )
            // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:14:9: 'private'
            {
            match("private"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__15"

    // $ANTLR start "T__16"
    public final void mT__16() throws RecognitionException {
        try {
            int _type = T__16;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:15:7: ( 'called' )
            // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:15:9: 'called'
            {
            match("called"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__16"

    // $ANTLR start "T__17"
    public final void mT__17() throws RecognitionException {
        try {
            int _type = T__17;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:16:7: ( 'abstract' )
            // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:16:9: 'abstract'
            {
            match("abstract"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__17"

    // $ANTLR start "T__18"
    public final void mT__18() throws RecognitionException {
        try {
            int _type = T__18;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:17:7: ( 'manual' )
            // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:17:9: 'manual'
            {
            match("manual"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__18"

    // $ANTLR start "T__19"
    public final void mT__19() throws RecognitionException {
        try {
            int _type = T__19;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:18:7: ( 'auto' )
            // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:18:9: 'auto'
            {
            match("auto"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__19"

    // $ANTLR start "T__20"
    public final void mT__20() throws RecognitionException {
        try {
            int _type = T__20;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:19:7: ( 'confirm' )
            // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:19:9: 'confirm'
            {
            match("confirm"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__20"

    // $ANTLR start "T__21"
    public final void mT__21() throws RecognitionException {
        try {
            int _type = T__21;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:20:7: ( 'use' )
            // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:20:9: 'use'
            {
            match("use"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__21"

    // $ANTLR start "T__22"
    public final void mT__22() throws RecognitionException {
        try {
            int _type = T__22;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:21:7: ( 'from' )
            // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:21:9: 'from'
            {
            match("from"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__22"

    // $ANTLR start "T__23"
    public final void mT__23() throws RecognitionException {
        try {
            int _type = T__23;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:22:7: ( 'into' )
            // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:22:9: 'into'
            {
            match("into"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__23"

    // $ANTLR start "T__24"
    public final void mT__24() throws RecognitionException {
        try {
            int _type = T__24;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:23:7: ( 'return' )
            // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:23:9: 'return'
            {
            match("return"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__24"

    // $ANTLR start "T__25"
    public final void mT__25() throws RecognitionException {
        try {
            int _type = T__25;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:24:7: ( 'create' )
            // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:24:9: 'create'
            {
            match("create"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__25"

    // $ANTLR start "T__26"
    public final void mT__26() throws RecognitionException {
        try {
            int _type = T__26;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:25:7: ( 'void' )
            // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:25:9: 'void'
            {
            match("void"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__26"

    // $ANTLR start "T__27"
    public final void mT__27() throws RecognitionException {
        try {
            int _type = T__27;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:26:7: ( 'any' )
            // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:26:9: 'any'
            {
            match("any"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__27"

    // $ANTLR start "T__28"
    public final void mT__28() throws RecognitionException {
        try {
            int _type = T__28;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:27:7: ( 'String' )
            // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:27:9: 'String'
            {
            match("String"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__28"

    // $ANTLR start "T__29"
    public final void mT__29() throws RecognitionException {
        try {
            int _type = T__29;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:28:7: ( 'int' )
            // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:28:9: 'int'
            {
            match("int"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__29"

    // $ANTLR start "T__30"
    public final void mT__30() throws RecognitionException {
        try {
            int _type = T__30;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:29:7: ( 'boolean' )
            // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:29:9: 'boolean'
            {
            match("boolean"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__30"

    // $ANTLR start "T__31"
    public final void mT__31() throws RecognitionException {
        try {
            int _type = T__31;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:30:7: ( 'real' )
            // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:30:9: 'real'
            {
            match("real"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__31"

    // $ANTLR start "T__32"
    public final void mT__32() throws RecognitionException {
        try {
            int _type = T__32;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:31:7: ( 'Type' )
            // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:31:9: 'Type'
            {
            match("Type"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__32"

    // $ANTLR start "T__33"
    public final void mT__33() throws RecognitionException {
        try {
            int _type = T__33;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:32:7: ( 'Collection' )
            // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:32:9: 'Collection'
            {
            match("Collection"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__33"

    // $ANTLR start "T__34"
    public final void mT__34() throws RecognitionException {
        try {
            int _type = T__34;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:33:7: ( 'Set' )
            // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:33:9: 'Set'
            {
            match("Set"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__34"

    // $ANTLR start "T__35"
    public final void mT__35() throws RecognitionException {
        try {
            int _type = T__35;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:34:7: ( 'OrderedSet' )
            // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:34:9: 'OrderedSet'
            {
            match("OrderedSet"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__35"

    // $ANTLR start "T__36"
    public final void mT__36() throws RecognitionException {
        try {
            int _type = T__36;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:35:7: ( 'Bag' )
            // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:35:9: 'Bag'
            {
            match("Bag"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__36"

    // $ANTLR start "T__37"
    public final void mT__37() throws RecognitionException {
        try {
            int _type = T__37;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:36:7: ( 'Sequence' )
            // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:36:9: 'Sequence'
            {
            match("Sequence"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__37"

    // $ANTLR start "T__38"
    public final void mT__38() throws RecognitionException {
        try {
            int _type = T__38;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:37:7: ( '&' )
            // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:37:9: '&'
            {
            match('&'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__38"

    // $ANTLR start "T__39"
    public final void mT__39() throws RecognitionException {
        try {
            int _type = T__39;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:38:7: ( '|' )
            // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:38:9: '|'
            {
            match('|'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__39"

    // $ANTLR start "T__40"
    public final void mT__40() throws RecognitionException {
        try {
            int _type = T__40;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:39:7: ( '&&' )
            // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:39:9: '&&'
            {
            match("&&"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__40"

    // $ANTLR start "T__41"
    public final void mT__41() throws RecognitionException {
        try {
            int _type = T__41;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:40:7: ( '||' )
            // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:40:9: '||'
            {
            match("||"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__41"

    // $ANTLR start "T__42"
    public final void mT__42() throws RecognitionException {
        try {
            int _type = T__42;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:41:7: ( '==' )
            // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:41:9: '=='
            {
            match("=="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__42"

    // $ANTLR start "T__43"
    public final void mT__43() throws RecognitionException {
        try {
            int _type = T__43;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:42:7: ( '!=' )
            // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:42:9: '!='
            {
            match("!="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__43"

    // $ANTLR start "T__44"
    public final void mT__44() throws RecognitionException {
        try {
            int _type = T__44;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:43:7: ( '<' )
            // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:43:9: '<'
            {
            match('<'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__44"

    // $ANTLR start "T__45"
    public final void mT__45() throws RecognitionException {
        try {
            int _type = T__45;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:44:7: ( '>' )
            // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:44:9: '>'
            {
            match('>'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__45"

    // $ANTLR start "T__46"
    public final void mT__46() throws RecognitionException {
        try {
            int _type = T__46;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:45:7: ( '<=' )
            // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:45:9: '<='
            {
            match("<="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__46"

    // $ANTLR start "T__47"
    public final void mT__47() throws RecognitionException {
        try {
            int _type = T__47;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:46:7: ( '>=' )
            // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:46:9: '>='
            {
            match(">="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__47"

    // $ANTLR start "T__48"
    public final void mT__48() throws RecognitionException {
        try {
            int _type = T__48;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:47:7: ( '+' )
            // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:47:9: '+'
            {
            match('+'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__48"

    // $ANTLR start "T__49"
    public final void mT__49() throws RecognitionException {
        try {
            int _type = T__49;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:48:7: ( '-' )
            // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:48:9: '-'
            {
            match('-'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__49"

    // $ANTLR start "T__50"
    public final void mT__50() throws RecognitionException {
        try {
            int _type = T__50;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:49:7: ( '*' )
            // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:49:9: '*'
            {
            match('*'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__50"

    // $ANTLR start "T__51"
    public final void mT__51() throws RecognitionException {
        try {
            int _type = T__51;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:50:7: ( '/' )
            // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:50:9: '/'
            {
            match('/'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__51"

    // $ANTLR start "T__52"
    public final void mT__52() throws RecognitionException {
        try {
            int _type = T__52;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:51:7: ( '=' )
            // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:51:9: '='
            {
            match('='); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__52"

    // $ANTLR start "T__53"
    public final void mT__53() throws RecognitionException {
        try {
            int _type = T__53;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:52:7: ( '+=' )
            // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:52:9: '+='
            {
            match("+="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__53"

    // $ANTLR start "T__54"
    public final void mT__54() throws RecognitionException {
        try {
            int _type = T__54;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:53:7: ( '-=' )
            // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:53:9: '-='
            {
            match("-="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__54"

    // $ANTLR start "T__55"
    public final void mT__55() throws RecognitionException {
        try {
            int _type = T__55;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:54:7: ( '++' )
            // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:54:9: '++'
            {
            match("++"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__55"

    // $ANTLR start "T__56"
    public final void mT__56() throws RecognitionException {
        try {
            int _type = T__56;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:55:7: ( '--' )
            // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:55:9: '--'
            {
            match("--"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__56"

    // $ANTLR start "T__57"
    public final void mT__57() throws RecognitionException {
        try {
            int _type = T__57;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:56:7: ( 'module' )
            // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:56:9: 'module'
            {
            match("module"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__57"

    // $ANTLR start "T__58"
    public final void mT__58() throws RecognitionException {
        try {
            int _type = T__58;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:57:7: ( 'rule' )
            // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:57:9: 'rule'
            {
            match("rule"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__58"

    // $ANTLR start "T__59"
    public final void mT__59() throws RecognitionException {
        try {
            int _type = T__59;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:58:7: ( 'parameter' )
            // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:58:9: 'parameter'
            {
            match("parameter"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__59"

    // $ANTLR start "T__60"
    public final void mT__60() throws RecognitionException {
        try {
            int _type = T__60;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:59:7: ( 'package' )
            // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:59:9: 'package'
            {
            match("package"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__60"

    // $ANTLR start "T__61"
    public final void mT__61() throws RecognitionException {
        try {
            int _type = T__61;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:60:7: ( 'import' )
            // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:60:9: 'import'
            {
            match("import"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__61"

    // $ANTLR start "T__62"
    public final void mT__62() throws RecognitionException {
        try {
            int _type = T__62;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:61:7: ( 'metamodel' )
            // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:61:9: 'metamodel'
            {
            match("metamodel"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__62"

    // $ANTLR start "T__63"
    public final void mT__63() throws RecognitionException {
        try {
            int _type = T__63;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:62:7: ( '(' )
            // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:62:9: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__63"

    // $ANTLR start "T__64"
    public final void mT__64() throws RecognitionException {
        try {
            int _type = T__64;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:63:7: ( ')' )
            // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:63:9: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__64"

    // $ANTLR start "T__65"
    public final void mT__65() throws RecognitionException {
        try {
            int _type = T__65;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:64:7: ( ',' )
            // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:64:9: ','
            {
            match(','); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__65"

    // $ANTLR start "T__66"
    public final void mT__66() throws RecognitionException {
        try {
            int _type = T__66;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:65:7: ( 'replaces' )
            // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:65:9: 'replaces'
            {
            match("replaces"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__66"

    // $ANTLR start "T__67"
    public final void mT__67() throws RecognitionException {
        try {
            int _type = T__67;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:66:7: ( ':' )
            // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:66:9: ':'
            {
            match(':'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__67"

    // $ANTLR start "T__68"
    public final void mT__68() throws RecognitionException {
        try {
            int _type = T__68;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:67:7: ( 'implements' )
            // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:67:9: 'implements'
            {
            match("implements"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__68"

    // $ANTLR start "T__69"
    public final void mT__69() throws RecognitionException {
        try {
            int _type = T__69;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:68:7: ( 'overrides' )
            // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:68:9: 'overrides'
            {
            match("overrides"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__69"

    // $ANTLR start "T__70"
    public final void mT__70() throws RecognitionException {
        try {
            int _type = T__70;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:69:7: ( 'excludedBy' )
            // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:69:9: 'excludedBy'
            {
            match("excludedBy"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__70"

    // $ANTLR start "T__71"
    public final void mT__71() throws RecognitionException {
        try {
            int _type = T__71;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:70:7: ( 'trigger' )
            // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:70:9: 'trigger'
            {
            match("trigger"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__71"

    // $ANTLR start "T__72"
    public final void mT__72() throws RecognitionException {
        try {
            int _type = T__72;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:71:7: ( 'with' )
            // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:71:9: 'with'
            {
            match("with"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__72"

    // $ANTLR start "T__73"
    public final void mT__73() throws RecognitionException {
        try {
            int _type = T__73;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:72:7: ( 'when' )
            // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:72:9: 'when'
            {
            match("when"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__73"

    // $ANTLR start "T__74"
    public final void mT__74() throws RecognitionException {
        try {
            int _type = T__74;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:73:7: ( 'java' )
            // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:73:9: 'java'
            {
            match("java"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__74"

    // $ANTLR start "T__75"
    public final void mT__75() throws RecognitionException {
        try {
            int _type = T__75;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:74:7: ( '::' )
            // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:74:9: '::'
            {
            match("::"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__75"

    // $ANTLR start "T__76"
    public final void mT__76() throws RecognitionException {
        try {
            int _type = T__76;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:75:7: ( '{' )
            // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:75:9: '{'
            {
            match('{'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__76"

    // $ANTLR start "T__77"
    public final void mT__77() throws RecognitionException {
        try {
            int _type = T__77;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:76:7: ( '}' )
            // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:76:9: '}'
            {
            match('}'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__77"

    // $ANTLR start "T__78"
    public final void mT__78() throws RecognitionException {
        try {
            int _type = T__78;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:77:7: ( 'if' )
            // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:77:9: 'if'
            {
            match("if"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__78"

    // $ANTLR start "T__79"
    public final void mT__79() throws RecognitionException {
        try {
            int _type = T__79;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:78:7: ( 'else' )
            // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:78:9: 'else'
            {
            match("else"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__79"

    // $ANTLR start "T__80"
    public final void mT__80() throws RecognitionException {
        try {
            int _type = T__80;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:79:7: ( 'while' )
            // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:79:9: 'while'
            {
            match("while"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__80"

    // $ANTLR start "T__81"
    public final void mT__81() throws RecognitionException {
        try {
            int _type = T__81;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:80:7: ( 'do' )
            // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:80:9: 'do'
            {
            match("do"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__81"

    // $ANTLR start "T__82"
    public final void mT__82() throws RecognitionException {
        try {
            int _type = T__82;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:81:7: ( 'for' )
            // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:81:9: 'for'
            {
            match("for"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__82"

    // $ANTLR start "T__83"
    public final void mT__83() throws RecognitionException {
        try {
            int _type = T__83;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:82:7: ( 'break' )
            // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:82:9: 'break'
            {
            match("break"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__83"

    // $ANTLR start "T__84"
    public final void mT__84() throws RecognitionException {
        try {
            int _type = T__84;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:83:7: ( 'throw' )
            // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:83:9: 'throw'
            {
            match("throw"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__84"

    // $ANTLR start "T__85"
    public final void mT__85() throws RecognitionException {
        try {
            int _type = T__85;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:84:7: ( 'try' )
            // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:84:9: 'try'
            {
            match("try"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__85"

    // $ANTLR start "T__86"
    public final void mT__86() throws RecognitionException {
        try {
            int _type = T__86;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:85:7: ( 'finally' )
            // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:85:9: 'finally'
            {
            match("finally"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__86"

    // $ANTLR start "T__87"
    public final void mT__87() throws RecognitionException {
        try {
            int _type = T__87;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:86:7: ( 'catch' )
            // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:86:9: 'catch'
            {
            match("catch"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__87"

    // $ANTLR start "T__88"
    public final void mT__88() throws RecognitionException {
        try {
            int _type = T__88;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:87:7: ( '!' )
            // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:87:9: '!'
            {
            match('!'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__88"

    // $ANTLR start "T__89"
    public final void mT__89() throws RecognitionException {
        try {
            int _type = T__89;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:88:7: ( 'instanceof' )
            // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:88:9: 'instanceof'
            {
            match("instanceof"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__89"

    // $ANTLR start "T__90"
    public final void mT__90() throws RecognitionException {
        try {
            int _type = T__90;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:89:7: ( 'null' )
            // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:89:9: 'null'
            {
            match("null"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__90"

    // $ANTLR start "T__91"
    public final void mT__91() throws RecognitionException {
        try {
            int _type = T__91;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:90:7: ( 'new' )
            // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:90:9: 'new'
            {
            match("new"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__91"

    // $ANTLR start "T__92"
    public final void mT__92() throws RecognitionException {
        try {
            int _type = T__92;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:91:7: ( 'super' )
            // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:91:9: 'super'
            {
            match("super"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__92"

    // $ANTLR start "T__93"
    public final void mT__93() throws RecognitionException {
        try {
            int _type = T__93;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:92:7: ( '.' )
            // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:92:9: '.'
            {
            match('.'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__93"

    // $ANTLR start "T__94"
    public final void mT__94() throws RecognitionException {
        try {
            int _type = T__94;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:93:7: ( '<<' )
            // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:93:9: '<<'
            {
            match("<<"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__94"

    // $ANTLR start "T__95"
    public final void mT__95() throws RecognitionException {
        try {
            int _type = T__95;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:94:7: ( '>>' )
            // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:94:9: '>>'
            {
            match(">>"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__95"

    // $ANTLR start "T__96"
    public final void mT__96() throws RecognitionException {
        try {
            int _type = T__96;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:95:7: ( '->' )
            // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:95:9: '->'
            {
            match("->"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__96"

    // $ANTLR start "T__97"
    public final void mT__97() throws RecognitionException {
        try {
            int _type = T__97;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:96:7: ( 'default' )
            // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:96:9: 'default'
            {
            match("default"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__97"

    // $ANTLR start "T__98"
    public final void mT__98() throws RecognitionException {
        try {
            int _type = T__98;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:97:7: ( '$' )
            // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:97:9: '$'
            {
            match('$'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__98"

    // $ANTLR start "T__99"
    public final void mT__99() throws RecognitionException {
        try {
            int _type = T__99;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:98:7: ( 'annotation' )
            // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:98:9: 'annotation'
            {
            match("annotation"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__99"

    // $ANTLR start "T__100"
    public final void mT__100() throws RecognitionException {
        try {
            int _type = T__100;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:99:8: ( 'self' )
            // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:99:10: 'self'
            {
            match("self"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__100"

    // $ANTLR start "T__101"
    public final void mT__101() throws RecognitionException {
        try {
            int _type = T__101;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:100:8: ( '@' )
            // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:100:10: '@'
            {
            match('@'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__101"

    // $ANTLR start "T__102"
    public final void mT__102() throws RecognitionException {
        try {
            int _type = T__102;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:101:8: ( 'traced' )
            // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:101:10: 'traced'
            {
            match("traced"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__102"

    // $ANTLR start "T__103"
    public final void mT__103() throws RecognitionException {
        try {
            int _type = T__103;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:102:8: ( 'stealth' )
            // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:102:10: 'stealth'
            {
            match("stealth"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__103"

    // $ANTLR start "T__104"
    public final void mT__104() throws RecognitionException {
        try {
            int _type = T__104;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:103:8: ( 'virtual' )
            // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:103:10: 'virtual'
            {
            match("virtual"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__104"

    // $ANTLR start "T__105"
    public final void mT__105() throws RecognitionException {
        try {
            int _type = T__105;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:104:8: ( 'multi' )
            // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:104:10: 'multi'
            {
            match("multi"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__105"

    // $ANTLR start "T__106"
    public final void mT__106() throws RecognitionException {
        try {
            int _type = T__106;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:105:8: ( 'true' )
            // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:105:10: 'true'
            {
            match("true"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__106"

    // $ANTLR start "T__107"
    public final void mT__107() throws RecognitionException {
        try {
            int _type = T__107;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:106:8: ( 'required' )
            // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:106:10: 'required'
            {
            match("required"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__107"

    // $ANTLR start "RULE_FLOAT"
    public final void mRULE_FLOAT() throws RecognitionException {
        try {
            int _type = RULE_FLOAT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:18693:12: ( ( '0' .. '9' )* '.' ( '0' .. '9' )+ )
            // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:18693:14: ( '0' .. '9' )* '.' ( '0' .. '9' )+
            {
            // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:18693:14: ( '0' .. '9' )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>='0' && LA1_0<='9')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:18693:15: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            match('.'); 
            // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:18693:30: ( '0' .. '9' )+
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
            	    // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:18693:31: '0' .. '9'
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
            // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:18695:9: ( ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* )
            // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:18695:11: ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            {
            // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:18695:11: ( '^' )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0=='^') ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:18695:11: '^'
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

            // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:18695:40: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0>='0' && LA4_0<='9')||(LA4_0>='A' && LA4_0<='Z')||LA4_0=='_'||(LA4_0>='a' && LA4_0<='z')) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:
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
            // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:18697:10: ( ( '0' .. '9' )+ )
            // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:18697:12: ( '0' .. '9' )+
            {
            // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:18697:12: ( '0' .. '9' )+
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
            	    // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:18697:13: '0' .. '9'
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
            // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:18699:13: ( ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' ) )
            // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:18699:15: ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            {
            // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:18699:15: ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
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
                    // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:18699:16: '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"'
                    {
                    match('\"'); 
                    // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:18699:20: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )*
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
                    	    // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:18699:21: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' )
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
                    	    // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:18699:66: ~ ( ( '\\\\' | '\"' ) )
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
                    // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:18699:86: '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\''
                    {
                    match('\''); 
                    // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:18699:91: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )*
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
                    	    // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:18699:92: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' )
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
                    	    // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:18699:137: ~ ( ( '\\\\' | '\\'' ) )
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
            // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:18701:17: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:18701:19: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:18701:24: ( options {greedy=false; } : . )*
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
            	    // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:18701:52: .
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
            // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:18703:17: ( '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )? )
            // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:18703:19: '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )?
            {
            match("//"); 

            // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:18703:24: (~ ( ( '\\n' | '\\r' ) ) )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( ((LA10_0>='\u0000' && LA10_0<='\t')||(LA10_0>='\u000B' && LA10_0<='\f')||(LA10_0>='\u000E' && LA10_0<='\uFFFF')) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:18703:24: ~ ( ( '\\n' | '\\r' ) )
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

            // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:18703:40: ( ( '\\r' )? '\\n' )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0=='\n'||LA12_0=='\r') ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:18703:41: ( '\\r' )? '\\n'
                    {
                    // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:18703:41: ( '\\r' )?
                    int alt11=2;
                    int LA11_0 = input.LA(1);

                    if ( (LA11_0=='\r') ) {
                        alt11=1;
                    }
                    switch (alt11) {
                        case 1 :
                            // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:18703:41: '\\r'
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
            // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:18705:9: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:18705:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:18705:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
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
            	    // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:
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
            // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:18707:16: ( . )
            // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:18707:18: .
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
        // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:1:8: ( T__12 | T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | T__58 | T__59 | T__60 | T__61 | T__62 | T__63 | T__64 | T__65 | T__66 | T__67 | T__68 | T__69 | T__70 | T__71 | T__72 | T__73 | T__74 | T__75 | T__76 | T__77 | T__78 | T__79 | T__80 | T__81 | T__82 | T__83 | T__84 | T__85 | T__86 | T__87 | T__88 | T__89 | T__90 | T__91 | T__92 | T__93 | T__94 | T__95 | T__96 | T__97 | T__98 | T__99 | T__100 | T__101 | T__102 | T__103 | T__104 | T__105 | T__106 | T__107 | RULE_FLOAT | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER )
        int alt14=104;
        alt14 = dfa14.predict(input);
        switch (alt14) {
            case 1 :
                // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:1:10: T__12
                {
                mT__12(); 

                }
                break;
            case 2 :
                // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:1:16: T__13
                {
                mT__13(); 

                }
                break;
            case 3 :
                // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:1:22: T__14
                {
                mT__14(); 

                }
                break;
            case 4 :
                // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:1:28: T__15
                {
                mT__15(); 

                }
                break;
            case 5 :
                // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:1:34: T__16
                {
                mT__16(); 

                }
                break;
            case 6 :
                // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:1:40: T__17
                {
                mT__17(); 

                }
                break;
            case 7 :
                // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:1:46: T__18
                {
                mT__18(); 

                }
                break;
            case 8 :
                // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:1:52: T__19
                {
                mT__19(); 

                }
                break;
            case 9 :
                // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:1:58: T__20
                {
                mT__20(); 

                }
                break;
            case 10 :
                // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:1:64: T__21
                {
                mT__21(); 

                }
                break;
            case 11 :
                // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:1:70: T__22
                {
                mT__22(); 

                }
                break;
            case 12 :
                // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:1:76: T__23
                {
                mT__23(); 

                }
                break;
            case 13 :
                // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:1:82: T__24
                {
                mT__24(); 

                }
                break;
            case 14 :
                // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:1:88: T__25
                {
                mT__25(); 

                }
                break;
            case 15 :
                // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:1:94: T__26
                {
                mT__26(); 

                }
                break;
            case 16 :
                // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:1:100: T__27
                {
                mT__27(); 

                }
                break;
            case 17 :
                // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:1:106: T__28
                {
                mT__28(); 

                }
                break;
            case 18 :
                // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:1:112: T__29
                {
                mT__29(); 

                }
                break;
            case 19 :
                // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:1:118: T__30
                {
                mT__30(); 

                }
                break;
            case 20 :
                // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:1:124: T__31
                {
                mT__31(); 

                }
                break;
            case 21 :
                // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:1:130: T__32
                {
                mT__32(); 

                }
                break;
            case 22 :
                // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:1:136: T__33
                {
                mT__33(); 

                }
                break;
            case 23 :
                // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:1:142: T__34
                {
                mT__34(); 

                }
                break;
            case 24 :
                // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:1:148: T__35
                {
                mT__35(); 

                }
                break;
            case 25 :
                // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:1:154: T__36
                {
                mT__36(); 

                }
                break;
            case 26 :
                // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:1:160: T__37
                {
                mT__37(); 

                }
                break;
            case 27 :
                // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:1:166: T__38
                {
                mT__38(); 

                }
                break;
            case 28 :
                // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:1:172: T__39
                {
                mT__39(); 

                }
                break;
            case 29 :
                // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:1:178: T__40
                {
                mT__40(); 

                }
                break;
            case 30 :
                // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:1:184: T__41
                {
                mT__41(); 

                }
                break;
            case 31 :
                // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:1:190: T__42
                {
                mT__42(); 

                }
                break;
            case 32 :
                // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:1:196: T__43
                {
                mT__43(); 

                }
                break;
            case 33 :
                // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:1:202: T__44
                {
                mT__44(); 

                }
                break;
            case 34 :
                // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:1:208: T__45
                {
                mT__45(); 

                }
                break;
            case 35 :
                // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:1:214: T__46
                {
                mT__46(); 

                }
                break;
            case 36 :
                // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:1:220: T__47
                {
                mT__47(); 

                }
                break;
            case 37 :
                // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:1:226: T__48
                {
                mT__48(); 

                }
                break;
            case 38 :
                // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:1:232: T__49
                {
                mT__49(); 

                }
                break;
            case 39 :
                // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:1:238: T__50
                {
                mT__50(); 

                }
                break;
            case 40 :
                // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:1:244: T__51
                {
                mT__51(); 

                }
                break;
            case 41 :
                // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:1:250: T__52
                {
                mT__52(); 

                }
                break;
            case 42 :
                // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:1:256: T__53
                {
                mT__53(); 

                }
                break;
            case 43 :
                // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:1:262: T__54
                {
                mT__54(); 

                }
                break;
            case 44 :
                // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:1:268: T__55
                {
                mT__55(); 

                }
                break;
            case 45 :
                // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:1:274: T__56
                {
                mT__56(); 

                }
                break;
            case 46 :
                // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:1:280: T__57
                {
                mT__57(); 

                }
                break;
            case 47 :
                // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:1:286: T__58
                {
                mT__58(); 

                }
                break;
            case 48 :
                // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:1:292: T__59
                {
                mT__59(); 

                }
                break;
            case 49 :
                // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:1:298: T__60
                {
                mT__60(); 

                }
                break;
            case 50 :
                // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:1:304: T__61
                {
                mT__61(); 

                }
                break;
            case 51 :
                // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:1:310: T__62
                {
                mT__62(); 

                }
                break;
            case 52 :
                // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:1:316: T__63
                {
                mT__63(); 

                }
                break;
            case 53 :
                // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:1:322: T__64
                {
                mT__64(); 

                }
                break;
            case 54 :
                // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:1:328: T__65
                {
                mT__65(); 

                }
                break;
            case 55 :
                // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:1:334: T__66
                {
                mT__66(); 

                }
                break;
            case 56 :
                // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:1:340: T__67
                {
                mT__67(); 

                }
                break;
            case 57 :
                // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:1:346: T__68
                {
                mT__68(); 

                }
                break;
            case 58 :
                // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:1:352: T__69
                {
                mT__69(); 

                }
                break;
            case 59 :
                // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:1:358: T__70
                {
                mT__70(); 

                }
                break;
            case 60 :
                // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:1:364: T__71
                {
                mT__71(); 

                }
                break;
            case 61 :
                // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:1:370: T__72
                {
                mT__72(); 

                }
                break;
            case 62 :
                // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:1:376: T__73
                {
                mT__73(); 

                }
                break;
            case 63 :
                // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:1:382: T__74
                {
                mT__74(); 

                }
                break;
            case 64 :
                // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:1:388: T__75
                {
                mT__75(); 

                }
                break;
            case 65 :
                // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:1:394: T__76
                {
                mT__76(); 

                }
                break;
            case 66 :
                // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:1:400: T__77
                {
                mT__77(); 

                }
                break;
            case 67 :
                // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:1:406: T__78
                {
                mT__78(); 

                }
                break;
            case 68 :
                // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:1:412: T__79
                {
                mT__79(); 

                }
                break;
            case 69 :
                // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:1:418: T__80
                {
                mT__80(); 

                }
                break;
            case 70 :
                // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:1:424: T__81
                {
                mT__81(); 

                }
                break;
            case 71 :
                // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:1:430: T__82
                {
                mT__82(); 

                }
                break;
            case 72 :
                // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:1:436: T__83
                {
                mT__83(); 

                }
                break;
            case 73 :
                // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:1:442: T__84
                {
                mT__84(); 

                }
                break;
            case 74 :
                // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:1:448: T__85
                {
                mT__85(); 

                }
                break;
            case 75 :
                // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:1:454: T__86
                {
                mT__86(); 

                }
                break;
            case 76 :
                // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:1:460: T__87
                {
                mT__87(); 

                }
                break;
            case 77 :
                // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:1:466: T__88
                {
                mT__88(); 

                }
                break;
            case 78 :
                // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:1:472: T__89
                {
                mT__89(); 

                }
                break;
            case 79 :
                // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:1:478: T__90
                {
                mT__90(); 

                }
                break;
            case 80 :
                // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:1:484: T__91
                {
                mT__91(); 

                }
                break;
            case 81 :
                // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:1:490: T__92
                {
                mT__92(); 

                }
                break;
            case 82 :
                // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:1:496: T__93
                {
                mT__93(); 

                }
                break;
            case 83 :
                // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:1:502: T__94
                {
                mT__94(); 

                }
                break;
            case 84 :
                // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:1:508: T__95
                {
                mT__95(); 

                }
                break;
            case 85 :
                // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:1:514: T__96
                {
                mT__96(); 

                }
                break;
            case 86 :
                // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:1:520: T__97
                {
                mT__97(); 

                }
                break;
            case 87 :
                // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:1:526: T__98
                {
                mT__98(); 

                }
                break;
            case 88 :
                // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:1:532: T__99
                {
                mT__99(); 

                }
                break;
            case 89 :
                // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:1:538: T__100
                {
                mT__100(); 

                }
                break;
            case 90 :
                // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:1:545: T__101
                {
                mT__101(); 

                }
                break;
            case 91 :
                // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:1:552: T__102
                {
                mT__102(); 

                }
                break;
            case 92 :
                // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:1:559: T__103
                {
                mT__103(); 

                }
                break;
            case 93 :
                // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:1:566: T__104
                {
                mT__104(); 

                }
                break;
            case 94 :
                // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:1:573: T__105
                {
                mT__105(); 

                }
                break;
            case 95 :
                // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:1:580: T__106
                {
                mT__106(); 

                }
                break;
            case 96 :
                // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:1:587: T__107
                {
                mT__107(); 

                }
                break;
            case 97 :
                // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:1:594: RULE_FLOAT
                {
                mRULE_FLOAT(); 

                }
                break;
            case 98 :
                // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:1:605: RULE_ID
                {
                mRULE_ID(); 

                }
                break;
            case 99 :
                // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:1:613: RULE_INT
                {
                mRULE_INT(); 

                }
                break;
            case 100 :
                // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:1:622: RULE_STRING
                {
                mRULE_STRING(); 

                }
                break;
            case 101 :
                // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:1:634: RULE_ML_COMMENT
                {
                mRULE_ML_COMMENT(); 

                }
                break;
            case 102 :
                // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:1:650: RULE_SL_COMMENT
                {
                mRULE_SL_COMMENT(); 

                }
                break;
            case 103 :
                // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:1:666: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 104 :
                // ../de.jevopi.mitra2.ui/src-gen/de/jevopi/mitra2/ui/contentassist/antlr/internal/InternalMitra.g:1:674: RULE_ANY_OTHER
                {
                mRULE_ANY_OTHER(); 

                }
                break;

        }

    }


    protected DFA14 dfa14 = new DFA14(this);
    static final String DFA14_eotS =
        "\2\uffff\17\70\1\127\1\131\1\133\1\135\1\140\1\143\1\146\1\152\1"+
        "\uffff\1\156\3\uffff\1\163\5\70\2\uffff\3\70\1\u0085\2\uffff\1\u0089"+
        "\1\62\1\uffff\2\62\3\uffff\4\70\1\uffff\20\70\1\u00a5\14\70\36\uffff"+
        "\10\70\2\uffff\1\u00c2\6\70\5\uffff\1\u0089\2\uffff\2\70\1\u00cb"+
        "\13\70\1\u00d7\5\70\1\u00dd\1\u00df\2\70\1\uffff\10\70\1\u00eb\6"+
        "\70\1\u00f2\4\70\1\u00f7\7\70\1\uffff\2\70\1\u0101\4\70\1\u0106"+
        "\1\uffff\12\70\1\u0111\1\uffff\5\70\1\uffff\1\u0117\1\uffff\4\70"+
        "\1\u011c\2\70\1\u011f\1\u0120\2\70\1\uffff\3\70\1\u0126\2\70\1\uffff"+
        "\2\70\1\u012b\1\70\1\uffff\1\70\1\u012e\1\70\1\u0130\1\u0131\1\70"+
        "\1\u0133\1\70\1\u0135\1\uffff\1\70\1\u0137\1\70\1\u0139\1\uffff"+
        "\6\70\1\u0140\3\70\1\uffff\4\70\1\u0148\1\uffff\4\70\1\uffff\2\70"+
        "\2\uffff\4\70\1\u0153\1\uffff\4\70\1\uffff\2\70\1\uffff\1\u015a"+
        "\2\uffff\1\u015b\1\uffff\1\70\1\uffff\1\u015d\1\uffff\1\70\1\uffff"+
        "\1\70\1\u0160\3\70\1\u0164\1\uffff\1\70\1\u0166\2\70\1\u0169\1\u016a"+
        "\1\70\1\uffff\1\70\1\u016d\1\70\1\u016f\3\70\1\u0173\2\70\1\uffff"+
        "\5\70\1\u017b\2\uffff\1\70\1\uffff\1\70\1\u017e\1\uffff\1\u017f"+
        "\1\70\1\u0181\1\uffff\1\u0182\1\uffff\2\70\2\uffff\2\70\1\uffff"+
        "\1\70\1\uffff\2\70\1\u018a\1\uffff\1\70\1\u018c\4\70\1\u0191\1\uffff"+
        "\1\u0192\1\u0193\2\uffff\1\70\2\uffff\1\u0195\4\70\1\u019a\1\u019b"+
        "\1\uffff\1\u019c\1\uffff\4\70\3\uffff\1\u01a1\1\uffff\1\70\1\u01a3"+
        "\2\70\3\uffff\2\70\1\u01a8\1\70\1\uffff\1\u01aa\1\uffff\1\u01ab"+
        "\1\u01ac\1\u01ad\1\u01ae\1\uffff\1\u01af\6\uffff";
    static final String DFA14_eofS =
        "\u01b0\uffff";
    static final String DFA14_minS =
        "\1\0\1\uffff\3\141\1\142\1\141\1\163\1\146\1\145\1\151\1\145\1\157"+
        "\1\171\1\157\1\162\1\141\1\46\1\174\2\75\1\74\1\75\1\53\1\55\1\uffff"+
        "\1\52\3\uffff\1\72\1\166\1\154\2\150\1\141\2\uffff\3\145\1\60\2"+
        "\uffff\1\56\1\101\1\uffff\2\0\3\uffff\1\154\1\157\1\162\1\156\1"+
        "\uffff\1\142\1\151\1\143\1\154\1\156\1\145\1\163\1\164\2\156\1\144"+
        "\1\164\1\154\1\145\1\163\1\160\1\60\1\141\1\154\1\151\2\162\1\161"+
        "\1\157\1\145\1\160\1\154\1\144\1\147\36\uffff\1\145\1\143\1\163"+
        "\1\141\1\162\1\164\1\145\1\166\2\uffff\1\60\1\146\1\154\1\167\1"+
        "\160\1\154\1\145\5\uffff\1\56\2\uffff\1\163\1\155\1\60\1\141\1\154"+
        "\1\166\1\141\1\153\1\154\1\143\1\146\1\141\1\164\1\157\1\60\1\157"+
        "\2\165\1\141\1\164\2\60\1\164\1\154\1\uffff\1\165\2\154\1\165\1"+
        "\145\1\144\1\164\1\151\1\60\1\165\1\154\1\141\1\145\1\154\1\145"+
        "\1\60\1\162\1\154\1\145\1\147\1\60\1\143\1\145\1\157\1\150\1\156"+
        "\1\154\1\141\1\uffff\1\141\1\154\1\60\1\145\1\146\1\141\1\145\1"+
        "\60\1\uffff\1\154\1\151\1\141\1\155\1\141\1\145\1\150\1\151\1\164"+
        "\1\162\1\60\1\uffff\1\164\1\141\1\154\1\155\1\151\1\uffff\1\60\1"+
        "\uffff\1\141\1\162\1\145\1\162\1\60\1\141\1\151\2\60\1\165\1\156"+
        "\1\uffff\2\145\1\153\1\60\1\145\1\162\1\uffff\1\162\1\165\1\60\1"+
        "\147\1\uffff\1\145\1\60\1\167\2\60\1\145\1\60\1\165\1\60\1\uffff"+
        "\1\162\1\60\1\154\1\60\1\uffff\1\154\1\143\1\164\1\145\1\147\1\144"+
        "\1\60\1\162\1\145\1\141\1\uffff\1\141\1\154\1\145\1\157\1\60\1\uffff"+
        "\1\156\1\164\1\155\1\156\1\uffff\1\143\1\162\2\uffff\1\141\1\147"+
        "\1\156\1\141\1\60\1\uffff\1\143\1\145\1\151\1\144\1\uffff\1\145"+
        "\1\144\1\uffff\1\60\2\uffff\1\60\1\uffff\1\154\1\uffff\1\60\1\uffff"+
        "\1\164\1\uffff\1\171\1\60\1\145\1\164\1\145\1\60\1\uffff\1\155\1"+
        "\60\1\143\1\164\2\60\1\144\1\uffff\1\143\1\60\1\145\1\60\2\145\1"+
        "\154\1\60\1\143\1\156\1\uffff\1\164\2\144\1\145\1\162\1\60\2\uffff"+
        "\1\164\1\uffff\1\150\1\60\1\uffff\1\60\1\145\1\60\1\uffff\1\60\1"+
        "\uffff\1\164\1\151\2\uffff\2\145\1\uffff\1\156\1\uffff\1\163\1\144"+
        "\1\60\1\uffff\1\145\1\60\1\151\1\123\1\145\1\144\1\60\1\uffff\2"+
        "\60\2\uffff\1\162\2\uffff\1\60\1\157\1\154\1\157\1\164\2\60\1\uffff"+
        "\1\60\1\uffff\1\157\1\145\1\163\1\102\3\uffff\1\60\1\uffff\1\156"+
        "\1\60\1\146\1\163\3\uffff\1\156\1\164\1\60\1\171\1\uffff\1\60\1"+
        "\uffff\4\60\1\uffff\1\60\6\uffff";
    static final String DFA14_maxS =
        "\1\uffff\1\uffff\1\162\1\165\1\162\2\165\1\163\1\156\1\165\1\157"+
        "\1\164\1\162\1\171\1\157\1\162\1\141\1\46\1\174\3\75\1\76\1\75\1"+
        "\76\1\uffff\1\57\3\uffff\1\72\1\166\1\170\1\162\1\151\1\141\2\uffff"+
        "\1\157\2\165\1\71\2\uffff\1\71\1\172\1\uffff\2\uffff\3\uffff\1\154"+
        "\1\157\1\162\1\156\1\uffff\1\142\1\151\1\162\1\164\1\156\1\145\1"+
        "\163\1\164\1\171\1\156\1\144\1\164\1\154\1\145\1\164\1\160\1\172"+
        "\1\164\1\154\1\151\2\162\1\164\1\157\1\145\1\160\1\154\1\144\1\147"+
        "\36\uffff\1\145\1\143\1\163\1\171\1\162\1\164\1\151\1\166\2\uffff"+
        "\1\172\1\146\1\154\1\167\1\160\1\154\1\145\5\uffff\1\71\2\uffff"+
        "\1\163\1\155\1\172\1\141\1\154\1\166\1\141\1\153\1\154\1\143\1\146"+
        "\1\141\1\164\1\157\1\172\1\157\2\165\1\141\1\164\2\172\1\164\1\157"+
        "\1\uffff\1\165\2\154\1\165\1\145\1\144\1\164\1\151\1\172\1\165\1"+
        "\154\1\141\1\145\1\154\1\145\1\172\1\162\1\154\1\145\1\147\1\172"+
        "\1\143\1\145\1\157\1\150\1\156\1\154\1\141\1\uffff\1\141\1\154\1"+
        "\172\1\145\1\146\1\141\1\145\1\172\1\uffff\1\154\1\151\1\141\1\155"+
        "\1\141\1\145\1\150\1\151\1\164\1\162\1\172\1\uffff\1\164\1\141\1"+
        "\154\1\155\1\151\1\uffff\1\172\1\uffff\1\141\1\162\1\145\1\162\1"+
        "\172\1\141\1\151\2\172\1\165\1\156\1\uffff\2\145\1\153\1\172\1\145"+
        "\1\162\1\uffff\1\162\1\165\1\172\1\147\1\uffff\1\145\1\172\1\167"+
        "\2\172\1\145\1\172\1\165\1\172\1\uffff\1\162\1\172\1\154\1\172\1"+
        "\uffff\1\154\1\143\1\164\1\145\1\147\1\144\1\172\1\162\1\145\1\141"+
        "\1\uffff\1\141\1\154\1\145\1\157\1\172\1\uffff\1\156\1\164\1\155"+
        "\1\156\1\uffff\1\143\1\162\2\uffff\1\141\1\147\1\156\1\141\1\172"+
        "\1\uffff\1\143\1\145\1\151\1\144\1\uffff\1\145\1\144\1\uffff\1\172"+
        "\2\uffff\1\172\1\uffff\1\154\1\uffff\1\172\1\uffff\1\164\1\uffff"+
        "\1\171\1\172\1\145\1\164\1\145\1\172\1\uffff\1\155\1\172\1\143\1"+
        "\164\2\172\1\144\1\uffff\1\143\1\172\1\145\1\172\2\145\1\154\1\172"+
        "\1\143\1\156\1\uffff\1\164\2\144\1\145\1\162\1\172\2\uffff\1\164"+
        "\1\uffff\1\150\1\172\1\uffff\1\172\1\145\1\172\1\uffff\1\172\1\uffff"+
        "\1\164\1\151\2\uffff\2\145\1\uffff\1\156\1\uffff\1\163\1\144\1\172"+
        "\1\uffff\1\145\1\172\1\151\1\123\1\145\1\144\1\172\1\uffff\2\172"+
        "\2\uffff\1\162\2\uffff\1\172\1\157\1\154\1\157\1\164\2\172\1\uffff"+
        "\1\172\1\uffff\1\157\1\145\1\163\1\102\3\uffff\1\172\1\uffff\1\156"+
        "\1\172\1\146\1\163\3\uffff\1\156\1\164\1\172\1\171\1\uffff\1\172"+
        "\1\uffff\4\172\1\uffff\1\172\6\uffff";
    static final String DFA14_acceptS =
        "\1\uffff\1\1\27\uffff\1\47\1\uffff\1\64\1\65\1\66\6\uffff\1\101"+
        "\1\102\4\uffff\1\127\1\132\2\uffff\1\142\2\uffff\1\147\1\150\1\1"+
        "\4\uffff\1\142\35\uffff\1\35\1\33\1\36\1\34\1\37\1\51\1\40\1\115"+
        "\1\43\1\123\1\41\1\44\1\124\1\42\1\52\1\54\1\45\1\53\1\55\1\125"+
        "\1\46\1\47\1\145\1\146\1\50\1\64\1\65\1\66\1\100\1\70\10\uffff\1"+
        "\101\1\102\7\uffff\1\122\1\141\1\127\1\132\1\143\1\uffff\1\144\1"+
        "\147\30\uffff\1\103\34\uffff\1\106\10\uffff\1\107\13\uffff\1\20"+
        "\5\uffff\1\12\1\uffff\1\22\13\uffff\1\27\6\uffff\1\31\4\uffff\1"+
        "\112\11\uffff\1\120\4\uffff\1\13\12\uffff\1\10\5\uffff\1\14\4\uffff"+
        "\1\24\2\uffff\1\57\1\17\5\uffff\1\25\4\uffff\1\104\2\uffff\1\137"+
        "\1\uffff\1\75\1\76\1\uffff\1\77\1\uffff\1\117\1\uffff\1\131\1\uffff"+
        "\1\2\6\uffff\1\114\7\uffff\1\136\12\uffff\1\110\6\uffff\1\111\1"+
        "\105\1\uffff\1\121\2\uffff\1\3\3\uffff\1\5\1\uffff\1\16\2\uffff"+
        "\1\7\1\56\2\uffff\1\62\1\uffff\1\15\3\uffff\1\21\7\uffff\1\133\2"+
        "\uffff\1\113\1\4\1\uffff\1\61\1\11\7\uffff\1\135\1\uffff\1\23\4"+
        "\uffff\1\74\1\126\1\134\1\uffff\1\6\4\uffff\1\67\1\140\1\32\4\uffff"+
        "\1\60\1\uffff\1\63\4\uffff\1\72\1\uffff\1\130\1\116\1\71\1\26\1"+
        "\30\1\73";
    static final String DFA14_specialS =
        "\1\0\56\uffff\1\2\1\1\u017f\uffff}>";
    static final String[] DFA14_transitionS = {
            "\11\62\2\61\2\62\1\61\22\62\1\61\1\24\1\57\1\62\1\52\1\62\1"+
            "\21\1\60\1\33\1\34\1\31\1\27\1\35\1\30\1\51\1\32\12\54\1\36"+
            "\1\1\1\25\1\23\1\26\1\62\1\53\1\56\1\20\1\16\13\56\1\17\3\56"+
            "\1\13\1\15\6\56\3\62\1\55\1\56\1\62\1\5\1\14\1\4\1\46\1\40\1"+
            "\2\2\56\1\10\1\43\2\56\1\6\1\47\1\37\1\3\1\56\1\11\1\50\1\41"+
            "\1\7\1\12\1\42\3\56\1\44\1\22\1\45\uff82\62",
            "",
            "\1\64\7\uffff\1\67\5\uffff\1\66\2\uffff\1\65",
            "\1\73\20\uffff\1\72\2\uffff\1\71",
            "\1\74\15\uffff\1\75\2\uffff\1\76",
            "\1\77\13\uffff\1\101\6\uffff\1\100",
            "\1\102\3\uffff\1\104\11\uffff\1\103\5\uffff\1\105",
            "\1\106",
            "\1\111\6\uffff\1\110\1\107",
            "\1\112\17\uffff\1\113",
            "\1\115\5\uffff\1\114",
            "\1\117\16\uffff\1\116",
            "\1\120\2\uffff\1\121",
            "\1\122",
            "\1\123",
            "\1\124",
            "\1\125",
            "\1\126",
            "\1\130",
            "\1\132",
            "\1\134",
            "\1\137\1\136",
            "\1\141\1\142",
            "\1\145\21\uffff\1\144",
            "\1\150\17\uffff\1\147\1\151",
            "",
            "\1\154\4\uffff\1\155",
            "",
            "",
            "",
            "\1\162",
            "\1\164",
            "\1\166\13\uffff\1\165",
            "\1\170\11\uffff\1\167",
            "\1\172\1\171",
            "\1\173",
            "",
            "",
            "\1\177\11\uffff\1\176",
            "\1\u0081\17\uffff\1\u0080",
            "\1\u0083\16\uffff\1\u0084\1\u0082",
            "\12\u0086",
            "",
            "",
            "\1\u0086\1\uffff\12\u008a",
            "\32\70\4\uffff\1\70\1\uffff\32\70",
            "",
            "\0\u008b",
            "\0\u008b",
            "",
            "",
            "",
            "\1\u008d",
            "\1\u008e",
            "\1\u008f",
            "\1\u0090",
            "",
            "\1\u0091",
            "\1\u0092",
            "\1\u0094\16\uffff\1\u0093",
            "\1\u0095\7\uffff\1\u0096",
            "\1\u0097",
            "\1\u0098",
            "\1\u0099",
            "\1\u009a",
            "\1\u009c\12\uffff\1\u009b",
            "\1\u009d",
            "\1\u009e",
            "\1\u009f",
            "\1\u00a0",
            "\1\u00a1",
            "\1\u00a3\1\u00a2",
            "\1\u00a4",
            "\12\70\7\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "\1\u00a7\16\uffff\1\u00a8\1\u00a9\2\uffff\1\u00a6",
            "\1\u00aa",
            "\1\u00ab",
            "\1\u00ac",
            "\1\u00ad",
            "\1\u00af\2\uffff\1\u00ae",
            "\1\u00b0",
            "\1\u00b1",
            "\1\u00b2",
            "\1\u00b3",
            "\1\u00b4",
            "\1\u00b5",
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
            "\1\u00b6",
            "\1\u00b7",
            "\1\u00b8",
            "\1\u00bb\7\uffff\1\u00b9\13\uffff\1\u00bc\3\uffff\1\u00ba",
            "\1\u00bd",
            "\1\u00be",
            "\1\u00bf\3\uffff\1\u00c0",
            "\1\u00c1",
            "",
            "",
            "\12\70\7\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
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
            "\1\u0086\1\uffff\12\u008a",
            "",
            "",
            "\1\u00c9",
            "\1\u00ca",
            "\12\70\7\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "\1\u00cc",
            "\1\u00cd",
            "\1\u00ce",
            "\1\u00cf",
            "\1\u00d0",
            "\1\u00d1",
            "\1\u00d2",
            "\1\u00d3",
            "\1\u00d4",
            "\1\u00d5",
            "\1\u00d6",
            "\12\70\7\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "\1\u00d8",
            "\1\u00d9",
            "\1\u00da",
            "\1\u00db",
            "\1\u00dc",
            "\12\70\7\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "\12\70\7\uffff\32\70\4\uffff\1\70\1\uffff\16\70\1\u00de\13"+
            "\70",
            "\1\u00e0",
            "\1\u00e2\2\uffff\1\u00e1",
            "",
            "\1\u00e3",
            "\1\u00e4",
            "\1\u00e5",
            "\1\u00e6",
            "\1\u00e7",
            "\1\u00e8",
            "\1\u00e9",
            "\1\u00ea",
            "\12\70\7\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "\1\u00ec",
            "\1\u00ed",
            "\1\u00ee",
            "\1\u00ef",
            "\1\u00f0",
            "\1\u00f1",
            "\12\70\7\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "\1\u00f3",
            "\1\u00f4",
            "\1\u00f5",
            "\1\u00f6",
            "\12\70\7\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "\1\u00f8",
            "\1\u00f9",
            "\1\u00fa",
            "\1\u00fb",
            "\1\u00fc",
            "\1\u00fd",
            "\1\u00fe",
            "",
            "\1\u00ff",
            "\1\u0100",
            "\12\70\7\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "\1\u0102",
            "\1\u0103",
            "\1\u0104",
            "\1\u0105",
            "\12\70\7\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "",
            "\1\u0107",
            "\1\u0108",
            "\1\u0109",
            "\1\u010a",
            "\1\u010b",
            "\1\u010c",
            "\1\u010d",
            "\1\u010e",
            "\1\u010f",
            "\1\u0110",
            "\12\70\7\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "",
            "\1\u0112",
            "\1\u0113",
            "\1\u0114",
            "\1\u0115",
            "\1\u0116",
            "",
            "\12\70\7\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "",
            "\1\u0118",
            "\1\u0119",
            "\1\u011a",
            "\1\u011b",
            "\12\70\7\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "\1\u011d",
            "\1\u011e",
            "\12\70\7\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "\12\70\7\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "\1\u0121",
            "\1\u0122",
            "",
            "\1\u0123",
            "\1\u0124",
            "\1\u0125",
            "\12\70\7\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "\1\u0127",
            "\1\u0128",
            "",
            "\1\u0129",
            "\1\u012a",
            "\12\70\7\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "\1\u012c",
            "",
            "\1\u012d",
            "\12\70\7\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "\1\u012f",
            "\12\70\7\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "\12\70\7\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "\1\u0132",
            "\12\70\7\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "\1\u0134",
            "\12\70\7\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "",
            "\1\u0136",
            "\12\70\7\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "\1\u0138",
            "\12\70\7\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "",
            "\1\u013a",
            "\1\u013b",
            "\1\u013c",
            "\1\u013d",
            "\1\u013e",
            "\1\u013f",
            "\12\70\7\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "\1\u0141",
            "\1\u0142",
            "\1\u0143",
            "",
            "\1\u0144",
            "\1\u0145",
            "\1\u0146",
            "\1\u0147",
            "\12\70\7\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "",
            "\1\u0149",
            "\1\u014a",
            "\1\u014b",
            "\1\u014c",
            "",
            "\1\u014d",
            "\1\u014e",
            "",
            "",
            "\1\u014f",
            "\1\u0150",
            "\1\u0151",
            "\1\u0152",
            "\12\70\7\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "",
            "\1\u0154",
            "\1\u0155",
            "\1\u0156",
            "\1\u0157",
            "",
            "\1\u0158",
            "\1\u0159",
            "",
            "\12\70\7\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "",
            "",
            "\12\70\7\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "",
            "\1\u015c",
            "",
            "\12\70\7\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "",
            "\1\u015e",
            "",
            "\1\u015f",
            "\12\70\7\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "\1\u0161",
            "\1\u0162",
            "\1\u0163",
            "\12\70\7\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "",
            "\1\u0165",
            "\12\70\7\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "\1\u0167",
            "\1\u0168",
            "\12\70\7\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "\12\70\7\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "\1\u016b",
            "",
            "\1\u016c",
            "\12\70\7\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "\1\u016e",
            "\12\70\7\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "\1\u0170",
            "\1\u0171",
            "\1\u0172",
            "\12\70\7\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "\1\u0174",
            "\1\u0175",
            "",
            "\1\u0176",
            "\1\u0177",
            "\1\u0178",
            "\1\u0179",
            "\1\u017a",
            "\12\70\7\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "",
            "",
            "\1\u017c",
            "",
            "\1\u017d",
            "\12\70\7\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "",
            "\12\70\7\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "\1\u0180",
            "\12\70\7\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "",
            "\12\70\7\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "",
            "\1\u0183",
            "\1\u0184",
            "",
            "",
            "\1\u0185",
            "\1\u0186",
            "",
            "\1\u0187",
            "",
            "\1\u0188",
            "\1\u0189",
            "\12\70\7\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "",
            "\1\u018b",
            "\12\70\7\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "\1\u018d",
            "\1\u018e",
            "\1\u018f",
            "\1\u0190",
            "\12\70\7\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "",
            "\12\70\7\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "\12\70\7\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "",
            "",
            "\1\u0194",
            "",
            "",
            "\12\70\7\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "\1\u0196",
            "\1\u0197",
            "\1\u0198",
            "\1\u0199",
            "\12\70\7\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "\12\70\7\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "",
            "\12\70\7\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "",
            "\1\u019d",
            "\1\u019e",
            "\1\u019f",
            "\1\u01a0",
            "",
            "",
            "",
            "\12\70\7\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "",
            "\1\u01a2",
            "\12\70\7\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "\1\u01a4",
            "\1\u01a5",
            "",
            "",
            "",
            "\1\u01a6",
            "\1\u01a7",
            "\12\70\7\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "\1\u01a9",
            "",
            "\12\70\7\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "",
            "\12\70\7\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "\12\70\7\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "\12\70\7\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "\12\70\7\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "",
            "\12\70\7\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
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
            return "1:1: Tokens : ( T__12 | T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | T__58 | T__59 | T__60 | T__61 | T__62 | T__63 | T__64 | T__65 | T__66 | T__67 | T__68 | T__69 | T__70 | T__71 | T__72 | T__73 | T__74 | T__75 | T__76 | T__77 | T__78 | T__79 | T__80 | T__81 | T__82 | T__83 | T__84 | T__85 | T__86 | T__87 | T__88 | T__89 | T__90 | T__91 | T__92 | T__93 | T__94 | T__95 | T__96 | T__97 | T__98 | T__99 | T__100 | T__101 | T__102 | T__103 | T__104 | T__105 | T__106 | T__107 | RULE_FLOAT | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA14_0 = input.LA(1);

                        s = -1;
                        if ( (LA14_0==';') ) {s = 1;}

                        else if ( (LA14_0=='f') ) {s = 2;}

                        else if ( (LA14_0=='p') ) {s = 3;}

                        else if ( (LA14_0=='c') ) {s = 4;}

                        else if ( (LA14_0=='a') ) {s = 5;}

                        else if ( (LA14_0=='m') ) {s = 6;}

                        else if ( (LA14_0=='u') ) {s = 7;}

                        else if ( (LA14_0=='i') ) {s = 8;}

                        else if ( (LA14_0=='r') ) {s = 9;}

                        else if ( (LA14_0=='v') ) {s = 10;}

                        else if ( (LA14_0=='S') ) {s = 11;}

                        else if ( (LA14_0=='b') ) {s = 12;}

                        else if ( (LA14_0=='T') ) {s = 13;}

                        else if ( (LA14_0=='C') ) {s = 14;}

                        else if ( (LA14_0=='O') ) {s = 15;}

                        else if ( (LA14_0=='B') ) {s = 16;}

                        else if ( (LA14_0=='&') ) {s = 17;}

                        else if ( (LA14_0=='|') ) {s = 18;}

                        else if ( (LA14_0=='=') ) {s = 19;}

                        else if ( (LA14_0=='!') ) {s = 20;}

                        else if ( (LA14_0=='<') ) {s = 21;}

                        else if ( (LA14_0=='>') ) {s = 22;}

                        else if ( (LA14_0=='+') ) {s = 23;}

                        else if ( (LA14_0=='-') ) {s = 24;}

                        else if ( (LA14_0=='*') ) {s = 25;}

                        else if ( (LA14_0=='/') ) {s = 26;}

                        else if ( (LA14_0=='(') ) {s = 27;}

                        else if ( (LA14_0==')') ) {s = 28;}

                        else if ( (LA14_0==',') ) {s = 29;}

                        else if ( (LA14_0==':') ) {s = 30;}

                        else if ( (LA14_0=='o') ) {s = 31;}

                        else if ( (LA14_0=='e') ) {s = 32;}

                        else if ( (LA14_0=='t') ) {s = 33;}

                        else if ( (LA14_0=='w') ) {s = 34;}

                        else if ( (LA14_0=='j') ) {s = 35;}

                        else if ( (LA14_0=='{') ) {s = 36;}

                        else if ( (LA14_0=='}') ) {s = 37;}

                        else if ( (LA14_0=='d') ) {s = 38;}

                        else if ( (LA14_0=='n') ) {s = 39;}

                        else if ( (LA14_0=='s') ) {s = 40;}

                        else if ( (LA14_0=='.') ) {s = 41;}

                        else if ( (LA14_0=='$') ) {s = 42;}

                        else if ( (LA14_0=='@') ) {s = 43;}

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