<template>
    <div class="row justify-content-center">
        <div class="col-8">
            <div v-if="replyVisitDataStat">
                <h2 class="jh-entity-heading"><span v-text="$t('vip1App.replyVisitDataStat.detail.title')">ReplyVisitDataStat</span> {{replyVisitDataStat.id}}</h2>
                <dl class="row jh-entity-details">
                    <dt>
                        <span v-text="$t('vip1App.replyVisitDataStat.clickCount')">Click Count</span>
                    </dt>
                    <dd>
                        <span>{{replyVisitDataStat.clickCount}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('vip1App.replyVisitDataStat.startDate')">Start Date</span>
                    </dt>
                    <dd>
                        <span>{{replyVisitDataStat.startDate}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('vip1App.replyVisitDataStat.endDate')">End Date</span>
                    </dt>
                    <dd>
                        <span>{{replyVisitDataStat.endDate}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('vip1App.replyVisitDataStat.source')">Source</span>
                    </dt>
                    <dd>
                        <span v-text="$t('vip1App.VisitSource.' + replyVisitDataStat.source)">{{replyVisitDataStat.source}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('vip1App.replyVisitDataStat.termimal')">Termimal</span>
                    </dt>
                    <dd>
                        <span>{{replyVisitDataStat.termimal}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('vip1App.replyVisitDataStat.replyCount')">Reply Count</span>
                    </dt>
                    <dd>
                        <span>{{replyVisitDataStat.replyCount}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('vip1App.replyVisitDataStat.starCount')">Star Count</span>
                    </dt>
                    <dd>
                        <span>{{replyVisitDataStat.starCount}}</span>
                    </dd>
                </dl>
                <button type="submit"
                        v-on:click.prevent="previousState()"
                        class="btn btn-info">
                    <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.back')"> Back</span>
                </button>
                <router-link v-if="replyVisitDataStat.id" :to="{name: 'ReplyVisitDataStatEdit', params: {replyVisitDataStatId: replyVisitDataStat.id}}" tag="button" class="btn btn-primary">
                    <font-awesome-icon icon="pencil-alt"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.edit')"> Edit</span>
                </router-link>
            </div>
        </div>
    </div>
</template>

<script lang="ts" src="./reply-visit-data-stat-details.component.ts">
</script>
